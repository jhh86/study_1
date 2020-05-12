package com.example.bball

import org.junit.Assert
import org.junit.Test

class KotlinTest {
    @Test
    fun test1(){

        var strike = 0;
        var ball = 0;
        var out = 0;

        // 결과값
        val lrandomNum = getNumber()

        var test = listOf<String>()

        println(test)
        if(test == null)
        {
            println("111")
        }else{
            println("222")
        }
        return
        //val lrandomNum = mutableListOf<String>("1","3","5")

        println("결과값 : ${lrandomNum}")
        // 입력값
        val sinputNum = "222"
        var linputNum = mutableListOf<String>()

        linputNum.add(sinputNum.substring(0,1))
        linputNum.add(sinputNum.substring(1,2))
        linputNum.add(sinputNum.substring(2,3))

        println("입력값 : ${linputNum}")

        // 초기화
        strike = 0; ball = 0; out = 0

        for(index in linputNum.indices){
            for(index2 in lrandomNum.indices ){
                //println( "입력값 : ${sinputNum[index]}, 결과값 : ${lrandomNum[index2]}")
                if(linputNum[index].equals(lrandomNum[index2])){
                    if(index == index2){
                        //println("스크라이크")
                        strike = strike + 1
                    }else{
                        //println("볼")
                        ball = ball + 1
                    }
                }
                out = 3 - (strike + ball)
            }
        }
        println( "${strike}스트라이크, ${ball}볼, ${out}아웃")

    }

    // 랜덤함수 Set
    fun getNumber(): MutableList<Int>{
        val list = mutableListOf<Int>()
        for(number in 0..9){ list.add(number) }
        list.shuffle() // 숫자섞기
        return list.subList(0,3) //List 3개 return
    }


}