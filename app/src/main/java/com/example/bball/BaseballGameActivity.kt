package com.example.bball

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.layout_baseballgame.*

class BaseballGameActivity : AppCompatActivity() {

    var strike = 0;
    var ball = 0;
    var out = 0;
    var tryChk = 0;
    var lrandomNum = listOfNotNull(String())
    var resultTmpText = ""
    var startEndChk = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_baseballgame)

        startButton.setOnClickListener{
            initData()
            startEndChk = true;
        }

        chkButton.setOnClickListener{

            if(startEndChk == false)
            {
                endText.text = "[게임시작]을 누르세요!"
                return@setOnClickListener
            }

            if(inputChk()) {
                chkData()
                drawApp()
            }
        }
    }

    //초기화
    fun initData(){
        strike = 0; ball = 0; out = 0; tryChk = 0;
        userInput.text = null
        resultText.text = ""
        endText.text = "10번의 기회!! 화이팅!"
        lrandomNum = getNumber()
    }

    fun inputChk():Boolean{

        var chkUserData = (userInput.text).toString()
        if( chkUserData == null || chkUserData == "" )
        {
            endText.text = "!! 숫자를 입력하세요 !!"
            return false
        }
        if ( chkUserData.length > 3){
            endText.text = "!! 3자리를 입력하세요 !!"
            return false
        }

        if(tryChk == 11){
            endText.text = "다시도전하시려면 [게임시작]을 누르세요!"
            startEndChk = false
            return false
        }

        return true
    }

    // 랜덤함수 Set
    fun getNumber(): MutableList<String>{
        val list = mutableListOf<String>()
        for(number in 0..9){ list.add(number.toString()) }
        list.shuffle() // 숫자섞기
        return list.subList(0,3) //List 3개 return
    }

    fun chkData(){
        CloseKeyboard()
        var userData = (userInput.text).toString()
        userInput.text = null
        var luserData = mutableListOf<String>()

        luserData.add(userData.substring(0,1))
        luserData.add(userData.substring(1,2))
        luserData.add(userData.substring(2,3))

        // 초기화
        strike = 0; ball = 0; out = 0

        for(index in lrandomNum.indices){
            for(index2 in lrandomNum.indices ){
                if(luserData[index].equals(lrandomNum[index2])){
                    if(index == index2){
                        strike = strike + 1
                    }else{
                        ball = ball + 1
                    }
                }
                out = 3 - (strike + ball)
            }
        }
        tryChk = tryChk + 1
        resultTmpText = "[${tryChk}번째 도전][${userData}] -> ${strike}스트라이크, ${ball}볼, ${out}아웃"
    }

    fun drawApp(){
        var resultAppText =  resultText.text
        if (tryChk == 1) {
            resultText.text = resultTmpText
        }else{
            resultText.text = "${resultAppText}\n${resultTmpText}"
        }

        if(strike == 3){
            endText.text = "성공!!정답[${lrandomNum}]\n다시도전하시려면 [게임시작]을 누르세요!"
            startEndChk = false
            return
       }

        if(tryChk == 10 ){
            endText.text = "실패!!정답[${lrandomNum}]\n다시도전하시려면 [게임시작]을 누르세요!"
            startEndChk = false
            return
        }

    }

    //키보드 내리기
    fun CloseKeyboard()
    {
        var view = this.currentFocus

        if(view != null)
        {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
    
}
