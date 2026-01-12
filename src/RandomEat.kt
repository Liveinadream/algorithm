import java.util.*
import kotlin.collections.ArrayList


object RandomEat {

    var manArray = emptyList<String>()
    var womenArray = emptyList<String>()
    var manSmaller: Boolean = false
    var random = 0

    @JvmStatic
    fun main(args: Array<String>) {

        //获取输入的男女姓名数组
        val input = Scanner(System.`in`)
        print("\n男生\n")
        //声明一个大小为用户输入大小的数组
        val man = setNames(input)
        manArray = man.split(",")

        print("\n女生\n")
        val women = setNames(input)
        womenArray = women.split(",")

        val firstArray = getTueArray(
                (manArray as ArrayList<String>).clone() as ArrayList<String>,
                (womenArray as ArrayList<String>).clone() as ArrayList<String>)

        print("周二的人的排列+$firstArray \n")

        val secondArray = getThuArray(firstArray.clone() as ArrayList<ArrayList<String>>)
        print("周四的人的排列+$secondArray")


    }


    /**
     * 获取一个组名字
     *
     * @param input 输入
     * @return 名字
     */
    fun setNames(input: Scanner): String {

        var name = input.next()
        if (name.isEmpty()) {
            print("\n请输入一个组正确的姓名\n")
            name = setNames(input)
        }
        return name
    }

    /**
     * 输入男女数组，获得周二展示的数组
     */

    fun getTueArray(man: ArrayList<String>, women: ArrayList<String>): ArrayList<ArrayList<String>> {

        val showManArray = ArrayList<ArrayList<String>>()
        val showWomenArray = ArrayList<ArrayList<String>>()

        //获取要生成的组
        val manArraySize = man.size / 2
        var random: Int
        for (i in 0 until manArraySize) {
            val useArray = ArrayList<String>()
            for (j in 0 until 2) {
                if (man.size > 0) {
                    random = Random().nextInt(man.size)
                    useArray.add(man[random])
                    man.removeAt(random)
                } else {
                    useArray.add(man[0])
                    man.removeAt(0)
                }

            }
            showManArray.add(useArray)
        }

        val womenArraySize = women.size / 2
        for (i in 0 until womenArraySize) {
            val useArray = ArrayList<String>()

            for (j in 0 until 2) {
                if (women.size > 0) {
                    random = Random().nextInt(women.size)
                    useArray.add(women[random])
                    women.removeAt(random)
                } else {
                    useArray.add(women[0])
                    man.removeAt(0)
                }

            }
            showWomenArray.add(useArray)
        }

        val small = if (manArraySize < womenArraySize) {
            manSmaller = false
            manArraySize
        } else {
            manSmaller = true
            womenArraySize
        }

        val showArray = ArrayList<ArrayList<String>>()
        for (i in 0 until small) {
            val show = ArrayList<String>()
            show.addAll(showManArray[i])
            show.addAll(showWomenArray[i])
            showArray.add(show)
        }

        val large = if (manSmaller) {
            showWomenArray.size
        } else {
            showManArray.size
        }

        for (i in small until large step 2) {
            val show = ArrayList<String>()
            if (manSmaller) {
                show.addAll(showWomenArray[i])
                show.addAll(showWomenArray[i + 1])
            } else {
                show.addAll(showManArray[i])
                show.addAll(showManArray[i + 1])
            }
            showArray.add(show)
        }

        return showArray
    }


    fun getThuArray(firstArray: ArrayList<ArrayList<String>>): ArrayList<ArrayList<String>> {

        val thisWomenArray = (womenArray as ArrayList<String>).clone() as ArrayList<String>
        val thisManArray = (manArray as ArrayList<String>).clone() as ArrayList<String>
        //打乱男女数组中的排序
        for (i in 0 until firstArray.size) {

            //判断哪输入的数组更大，将更大的输入进行乱序
            for (j in 0 until 4) {
                if (manSmaller) {
                    val name = firstArray[i][j]

                    //判断性别是否正确
                    if (womenArray.contains(firstArray[i][j])) {

                        //判断剩余数组中是否包含这个人，不包含代表已被拿走填坑
                        random = if (thisWomenArray.contains(firstArray[i][j])) {
                            if (thisWomenArray.size > 0) {
                                val nameIndex = thisWomenArray.indexOf(name)
                                getOther(nameIndex, thisWomenArray.size)
                            } else {
                                0
                            }
                        } else {
                            if (thisWomenArray.size > 0) {
                                Random().nextInt(thisWomenArray.size)
                            } else {
                                0
                            }
                        }
                        firstArray[i][j] = thisWomenArray[random]
                        thisWomenArray.remove(thisWomenArray[random])
                    } else {
                        random = if (thisManArray.contains(firstArray[i][j])) {
                            if (thisManArray.size > 0) {
                                val nameIndex = thisManArray.indexOf(name)
                                getOther(nameIndex, thisManArray.size)
                            } else {
                                0
                            }
                        } else {
                            if (thisManArray.size > 0) {
                                Random().nextInt(thisManArray.size)
                            } else {
                                0
                            }
                        }
                        firstArray[i][j] = thisManArray[random]
                        thisWomenArray.remove(thisManArray[random])
                    }


                } else {
                    if (manArray.contains(firstArray[i][j])) {

                        val name = firstArray[i][j]
                        //判断剩余数组中是否包含这个人，不包含代表已被拿走填坑
                        random = if (thisManArray.contains(firstArray[i][j])) {
                            if (thisManArray.size > 0) {
                                val nameIndex = thisManArray.indexOf(name)
                                getOther(nameIndex, thisManArray.size)
                            } else {
                                0
                            }

                        } else {
                            if (thisManArray.size > 0) {
                                Random().nextInt(thisManArray.size)
                            } else {
                                0
                            }
                        }
                        firstArray[i][j] = thisManArray[random]
                        thisManArray.remove(thisManArray[random])

                    }
                }

            }

        }
        return firstArray
    }

    //找到不同的数
    fun getOther(index: Int, range: Int): Int {
        random = Random().nextInt(range)
        if (random != index) {
            return random
        }
        return getOther(index, range)
    }
}

//data class person(val name: String, val sex: String, val index: String)

