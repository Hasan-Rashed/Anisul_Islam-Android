package com.rashed.html;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private WebView webView;
    //private TextView textView;

    String string = "<h1> This is heading 1</h1>\n" +
                    "<h2> This is heading 2</h2>\n" +
                    "<h3> This is heading 3</h3>\n" +
                    "<p> This is a paragraph</p>\n" +
                    "<p> <u> This is an underline text </u> </p>\n" +
                    "<p> <b> This is an bold text </b> </p>\n" +
                    "<p> <i> This is an italic text </i> </p>\n" +
                    "Programming language ordered list \n" +
                    "<ol>\n" +
                    "<li> C </li>\n" +
                    "<li> C++ </li>\n" +
                    "<li> Java </li>\n" +
                    "<ol>\n" +
                    "</ol>\n\n" +
                    "(a + b) <sup> 2 </sup> = (a) <sup> 2 </sup> + 2ab + (b) <sup> 2 </sup>";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        webView.loadDataWithBaseURL(null, string, "text/html", "utf-8", null);

//        textView = findViewById(R.id.textView);
//        textView.setText(Html.fromHtml(string));
    }
}