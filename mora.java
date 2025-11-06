package com.example.lab2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.BreakIterator;


public class MainActivity extends AppCompatActivity {

    private EditText ed_name;
    private TextView tv_Text , name , winner , mymora , commora;
    private RadioButton btn_scissor , btn_stone , btn_paper;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ed_name = findViewById(R.id.ed_name);
        tv_Text = findViewById(R.id.tv_Text);
        name = findViewById(R.id.name);
        winner = findViewById(R.id.winner);
        mymora = findViewById(R.id.mymora);
        commora = findViewById(R.id.commora);
        btn_scissor = findViewById(R.id.btn_scissor);
        btn_stone = findViewById(R.id.btn_stone);
        btn_paper = findViewById(R.id.btn_paper);
        button = findViewById(R.id.button);

        button.setOnClickListener(view -> {
            if(ed_name.length() < 1)
            {
                tv_Text.setText("請輸入玩家姓名");
            }
            else
            {
                name.setText(String.format("名字\n%s" , ed_name.getText().toString()));

                int player;
                if (btn_scissor.isChecked())
                {
                    mymora.setText("我方出拳\n剪刀");
                    player = 0;
                }
                else if(btn_stone.isChecked())
                {
                    mymora.setText("我方出拳\n石頭");
                    player = 1;
                }
                else if(btn_paper.isChecked())
                {
                    mymora.setText("我方出拳\n布");
                    player = 2;
                }

                // 使用隨機數產生電腦出拳，值為0~2。
                int computer = (int) (Math.random() * 3);
                // 顯示電腦出拳
                if (computer == 0) 
                {
                    commora.setText("電腦出拳\n剪刀");
                } 
                else if (computer == 1) 
                {
                    commora.setText("電腦出拳\n石頭");
                } 
                else if (computer == 2)
                {
                    commora.setText("電腦出拳\n布");
                }

                // 判斷勝負
                if ((player == 0 && computer == 2) ||
                        (player == 1 && computer == 0) ||
                        (player == 2 && computer == 1))
                {
                    winner.setText("勝利者\n" + ed_name.getText().toString());
                    tv_Text.setText("您贏了！！！");
                }

                else if(player == computer)
                {
                    winner.setText("勝利者\n平手");
                    tv_Text.setText("平手，請再試一次！");
                }
                
                else
                {
                    winner.setText("勝利者\n電腦贏了");
                    tv_Text.setText("可惜，電腦贏了！");
                }

                
            }
        });
    }
    }



