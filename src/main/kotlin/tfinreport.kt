import java.io.*
import java.net.URI
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import java.util.function.*
import java.util.stream.Collectors
import java.util.stream.Stream
import kotlin.math.roundToInt

class TrowData {
    var name: String = ""
    var debet: Double = 0.0
    var credit: Double = 0.0
    var operationDate: Date = Date()
    var operationMounth: Date = Date()
}

class TFinReport {
    var dataTable = ArrayList<TrowData>()

    fun LoadFromFiles(resPath: URI?) {
        val dir = File(resPath)
        val filter = FilenameFilter { dir, name ->
            var result = false
            if (name.uppercase(Locale.getDefault()).endsWith(".TXT")) {
                result = true
            }
            result
        }
        val txtFiles = dir.listFiles(filter)
        for (txtFile in txtFiles) {
            val currentFileName = txtFile.absolutePath
            try {
                val reader = FileReader(currentFileName)
                val bufReader = BufferedReader(reader)
                var firstLine = true
                while (bufReader.ready()) {
                    val currentLine = bufReader.readLine()
                    if (firstLine) {
                        firstLine = false
                        continue
                    }
                    val arrayData = currentLine.split(";".toRegex()).dropLastWhile { it.isEmpty() }
                        .toTypedArray()
                    val rowData = TrowData()
                    rowData.name = arrayData[0]
                    rowData.debet = arrayData[1].toDouble()
                    rowData.credit = arrayData[2].toDouble()
                    val dateFormater = SimpleDateFormat("dd/M/yyyy")
                    rowData.operationDate = dateFormater.parse(arrayData[3])
                    val calendar: Calendar = GregorianCalendar()
                    calendar.time = rowData.operationDate
                    calendar[Calendar.DAY_OF_MONTH] = 1
                    rowData.operationMounth = calendar.time
                    dataTable.add(rowData)
                }
            } catch (fileExсpt: IOException) {
                println(String.format("Не удалось прочитать файл %s по причине %s", currentFileName, fileExсpt.message))
                return
            } catch (dateExсpt: ParseException) {
                println(
                    String.format(
                        "Не удалось преобразовать данные о дате операции в формат даты по причине %s",
                        dateExсpt.message
                    )
                )
                return
            }
        }
    }

    fun getTotalsPerMonthByShop(shopName: String) {
        val tmpResult  =
            dataTable.filter{ rowData: TrowData -> rowData.name == shopName }
              .sortedBy {  rowData: TrowData -> rowData.operationMounth }
              .groupBy{ rowData: TrowData -> rowData.operationMounth}
              .mapValues{ it ->  it.value.sumOf { (it.debet - it.credit)  }}
              //.reduce { key, accumulator, element ->  element.credit}
              //}
              //.mapValues { rowData: TrowData -> rowData.debet - rowData.credit }
//            .map { Map<Date, Double>, Any>(
//                Collectors.groupingBy<TrowData, Date?, Any, Double>(
//                    Function { rowData: TrowData -> rowData.operationMounth }, Collectors.summingDouble(
//                        )
//                )
//            )
//        val sortedResult = tmpResult.entries.stream().sorted(
//            Comparator.comparing(
//                Function<Map.Entry<Date, Double>, Date> { (key, value) -> java.util.Map.Entry.key })
//        ).collect(
//            Collectors.toMap(
//                Function<Map.Entry<Date, Double>, Date> { (key, value) -> java.util.Map.Entry.key },
//                Function<Map.Entry<Date, Double>, Double> { (key, value) -> java.util.Map.Entry.value },
//                BinaryOperator { e1: Double, e2: Double? -> e1 },
//                Supplier { LinkedHashMap() })
//        )
//        println(String.format("Отчет о итоговой прибыли за каждый месяц по магазину %s", shopName))
//        val calendar: Calendar = GregorianCalendar()
//        for ((key, value): Map.Entry<Date, Double> in sortedResult) {
//            calendar.time = key as Date?
//            val userFriendlyDate = String.format("%02d", calendar[Calendar.MONTH] + 1) + "." + Integer.toString(
//                calendar[Calendar.YEAR]
//            )
//            val dF = DecimalFormat("#.00")
//            val userFriendlyValue = dF.format(value)
//            println("$userFriendlyDate : $userFriendlyValue")
//        }
        for(elem in tmpResult) println( elem )
    }
//
    fun getTotalsCreditsByShops() {
//        val tmpResult: Map<Any?, Double> = dataTable.stream().collect<Map<Any, Double>, Any>(
//            Collectors.groupingBy<TrowData, Any?, Any, Double>(
//                Function<TrowData, Any?> { rowData: TrowData -> rowData.name }, Collectors.summingDouble(
//                    ToDoubleFunction { rowData: TrowData -> rowData.credit!! })
//            )
//        )
//        println("Отчет о расходах всех магазинов за весь период по магазинам")
//        for ((key, value): Map.Entry<Any?, Double> in tmpResult) {
//            val caption = String.format("Расходы %s за весь период", key)
//            println("$caption : $value")
//        }
    }


}

fun main(args: Array<String>) {
    //DataGenerator.createReports();
    val resPath = "file:/D:/1c/skudashkin/Java/IdeaProjects/TfinRepport/src/res"
    var startTime = System.currentTimeMillis()
    val TfinReport = TFinReport()
    TfinReport.LoadFromFiles(URI(resPath))
    var stopTime = System.currentTimeMillis()
    println("Время чтения данных " + java.lang.Long.toString(stopTime - startTime))

        val shopName = "pyterochka"
        startTime = System.currentTimeMillis()
        TfinReport.getTotalsPerMonthByShop(shopName)
        stopTime = System.currentTimeMillis()
        println("Время обработки " + java.lang.Long.toString(stopTime - startTime))
        println("Обработано записей " + Integer.toString(TfinReport.dataTable.size))
//        println("                ----------------------------------------------              ")
//        startTime = System.currentTimeMillis()
//        TfinReport.getTotalsCreditsByShops()
//        stopTime = System.currentTimeMillis()
//        println("Время обработки " + java.lang.Long.toString(stopTime - startTime))
}