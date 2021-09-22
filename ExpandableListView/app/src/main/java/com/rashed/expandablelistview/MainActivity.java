package com.rashed.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private CustomAdapter customAdapter;
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();

        expandableListView = findViewById(R.id.expandableListView);
        customAdapter = new CustomAdapter(this, listDataHeader, listDataChild);
        expandableListView.setAdapter(customAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
        {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l)
            {
                String groupName = listDataHeader.get(i);
                Toast.makeText(getApplicationContext(), "group name: " + groupName, Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener()
        {
            @Override
            public void onGroupCollapse(int i)
            {
                String groupName = listDataHeader.get(i);
                Toast.makeText(getApplicationContext(), groupName + " is collapsed", Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
        {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l)
            {
                String s = listDataChild.get(listDataHeader.get(i)).get(i1);
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener()
        {
            @Override
            public void onGroupExpand(int i)
            {
                if (lastExpandedPosition != -1 && lastExpandedPosition != i)
                {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;
            }
        });
    }

    public void prepareListData()
    {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        listDataHeader.add("1. OverView");
        listDataHeader.add("2. Environment setup");
        listDataHeader.add("3. Program structure");
        listDataHeader.add("4. Print scanf");
        listDataHeader.add("5. Keyword");
        listDataHeader.add("6. Data types");
        listDataHeader.add("7. Variables");
        listDataHeader.add("8. Operators");
        listDataHeader.add("9. Comments");
        listDataHeader.add("10. Math.h");
        listDataHeader.add("11. Control structure");
        listDataHeader.add("12. Array");
        listDataHeader.add("13. String");
        listDataHeader.add("14. Function");
        listDataHeader.add("15. Pointer");
        listDataHeader.add("16. Structure & Union");
        listDataHeader.add("17. Files");

        List<String> overview = new ArrayList<>();
        overview.add("1.1 What is C language");
        overview.add("1.2 History of C");
        overview.add("1.1 Features of C");
        overview.add("1.1 Advantages of C");

        List<String> environmentSetup = new ArrayList<>();
        environmentSetup.add("2.1 How to install Codeblocks");

        List<String> programStructure = new ArrayList<>();
        programStructure.add("3.1 program structure");

        List<String> printScanf = new ArrayList<>();
        printScanf.add("4.1 print scanf in C");

        List<String> keywords = new ArrayList<>();
        keywords.add("5.1 keywords in C");

        List<String> dataTypes = new ArrayList<>();
        dataTypes.add("6.1 Data types in C");

        List<String> variables = new ArrayList<>();
        variables.add("7.1 variables in C");
        variables.add("7.2 variables Test");

        List<String> operatorList = new ArrayList<>();
        operatorList.add("8.1 what is operator");
        operatorList.add("8.2 Arithmetic operator");
        operatorList.add("8.3 Assignment operator");
        operatorList.add("8.4 Relational operator");
        operatorList.add("8.5 Logical operator");
        operatorList.add("8.6 Bitwise operator");
        operatorList.add("8.7 Unary operator");
        operatorList.add("8.8 Ternary operator");
        operatorList.add("8.9 Operator operator");

        List<String> comment = new ArrayList<>();
        comment.add("9.1 comments in c");

        List<String> math = new ArrayList<>();
        math.add("10.1 math function in c");

        List<String> controlStatements = new ArrayList<>();
        controlStatements.add("11.1 if-else");
        controlStatements.add("11.2 switch");
        controlStatements.add("11.3 loop");
        controlStatements.add("11.4 for loop");
        controlStatements.add("11.5 while loop");
        controlStatements.add("11.6 do while");
        controlStatements.add("11.7 break");
        controlStatements.add("11.8 continue");
        controlStatements.add("11.9 goto");
        controlStatements.add("11.10 control statement test");

        List<String> array = new ArrayList<>();
        array.add("12.1 one dimensional array");
        array.add("12.2 two dimensional array");
        array.add("12.3 array of function");
        array.add("12.4 Array test");

        List<String> strings = new ArrayList<>();
        strings.add("13.1 strings in c");
        strings.add("13.2 c string function");
        strings.add("13.3 strlen()");
        strings.add("13.4 strcpy()");
        strings.add("13.5 strcat()");
        strings.add("13.6 strcmp()");
        strings.add("13.7 strrev()");
        strings.add("13.8 strlwr()");
        strings.add("13.9 strupr()");
        strings.add("13.10 String Test");

        List<String> functions = new ArrayList<>();
        functions.add("14.1 functions in c");
        functions.add("14.2 Call: value & reference");
        functions.add("14.3 recursion");
        functions.add("14.4 Function Test");

        List<String> pointer = new ArrayList<>();
        pointer.add("15.1 pointer in c");
        pointer.add("15.2 pointer to pointer");
        pointer.add("15.1 Pointer Arithmetic");
        pointer.add("15.1 Pointer Test");

        List<String> structureUnion = new ArrayList<>();
        structureUnion.add("16.1 structure in c");
        structureUnion.add("16.2 Array of structure");
        structureUnion.add("16.3 Union in c");
        structureUnion.add("16.4 Structure Test");

        List<String> files = new ArrayList<>();
        files.add("17.1 file handling in c");
        files.add("17.2 fprintf() fscanf()");
        files.add("17.3 fputc() fgetc()");
        files.add("17.4 fputs() fgets()");
        files.add("17.5 fseek()");
        files.add("17.6 rewind()");
        files.add("17.7 ftell()");

        listDataChild.put(listDataHeader.get(0), overview);
        listDataChild.put(listDataHeader.get(1), environmentSetup);
        listDataChild.put(listDataHeader.get(2), programStructure);
        listDataChild.put(listDataHeader.get(3), printScanf);
        listDataChild.put(listDataHeader.get(4), keywords);
        listDataChild.put(listDataHeader.get(5), dataTypes);
        listDataChild.put(listDataHeader.get(6), variables);
        listDataChild.put(listDataHeader.get(7), operatorList);
        listDataChild.put(listDataHeader.get(8), comment);
        listDataChild.put(listDataHeader.get(9), math);
        listDataChild.put(listDataHeader.get(10), controlStatements);
        listDataChild.put(listDataHeader.get(11), array);
        listDataChild.put(listDataHeader.get(12), strings);
        listDataChild.put(listDataHeader.get(13), functions);
        listDataChild.put(listDataHeader.get(14), pointer);
        listDataChild.put(listDataHeader.get(15), structureUnion);
        listDataChild.put(listDataHeader.get(16), files);
    }
}