package com.example.lab2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.EdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random 

class MainActivity : AppCompatActivity() { 

    
    private lateinit var edName: EditText
    private lateinit var tvText: TextView
    private lateinit var nameTextView: TextView 
    private lateinit var winnerTextView: TextView 
    private lateinit var myMoraTextView: TextView 
    private lateinit var commoraTextView: TextView 
    private lateinit var btnScissor: RadioButton
    private lateinit var btnStone: RadioButton
    private lateinit var btnPaper: RadioButton
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) { 
        super.onCreate(savedInstanceState)
        EdgeToEdge.enable(this)
        setContentView(R.layout.activity_main)

        
        edName = findViewById(R.id.ed_name)
        tvText = findViewById(R.id.tv_Text)
        nameTextView = findViewById(R.id.name)
        winnerTextView = findViewById(R.id.winner)
        myMoraTextView = findViewById(R.id.mymora)
        commoraTextView = findViewById(R.id.commora)
        btnScissor = findViewById(R.id.btn_scissor)
        btnStone = findViewById(R.id.btn_stone)
        btnPaper = findViewById(R.id.btn_paper)
        button = findViewById(R.id.button)

        
        button.setOnClickListener {
            
            if (edName.text.isNullOrEmpty()) { 
                tvText.text = "請輸入玩家姓名"
            } else {
                
                val playerName = edName.text.toString() 
                nameTextView.text = "名字\n$playerName" 

                val playerChoice: Int = when { 
                    btnScissor.isChecked -> {
                        myMoraTextView.text = "我方出拳\n剪刀"
                        0 
                    }
                    btnStone.isChecked -> {
                        myMoraTextView.text = "我方出拳\n石頭"
                        1 
                    }
                    btnPaper.isChecked -> {
                        myMoraTextView.text = "我方出拳\n布"
                        2 // 布
                    }
                    else -> -1 
                }

                
                val computer = Random.nextInt(3)

                
                when (computer) {
                    0 -> commoraTextView.text = "電腦出拳\n剪刀"
                    1 -> commoraTextView.text = "電腦出拳\n石頭"
                    2 -> commoraTextView.text = "電腦出拳\n布"
                }

                
                when {
                    (playerChoice == 0 && computer == 2) ||
                    (playerChoice == 1 && computer == 0) ||
                    (playerChoice == 2 && computer == 1) 
                    -> {
                        winnerTextView.text = "勝利者\n$playerName"
                        tvText.text = "您贏了！！！"
                    }
                    playerChoice == computer -> {
                        winnerTextView.text = "勝利者\n平手"
                        tvText.text = "平手，請再試一次！"
                    }
                    else -> {
                        winnerTextView.text = "勝利者\n電腦贏了"
                        tvText.text = "可惜，電腦贏了！"
                    }
                }
            }
        }
    }
}