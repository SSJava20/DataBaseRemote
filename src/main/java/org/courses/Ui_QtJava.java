package org.courses;
/********************************************************************************
 ** Form generated from reading ui file 'QtJava.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.7.0
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_QtJava implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QWidget centralwidget;
    public QGridLayout gridLayout;
    public QVBoxLayout verticalLayout;
    public QPushButton btDoIt;
    public QPushButton btAdd;
    public QPushButton btDel;
    public QGraphicsView graphicsView_2;
    public QTableWidget tableWidget;
    public QStatusBar statusbar;

    public Ui_QtJava() { super(); }

    public void setupUi(QMainWindow QtJava)
    {
        QtJava.setObjectName("QtJava");
        QtJava.resize(new QSize(800, 600).expandedTo(QtJava.minimumSizeHint()));
        centralwidget = new QWidget(QtJava);
        centralwidget.setObjectName("centralwidget");
        gridLayout = new QGridLayout(centralwidget);
        gridLayout.setObjectName("gridLayout");
        verticalLayout = new QVBoxLayout();
        verticalLayout.setObjectName("verticalLayout");
        btDoIt = new QPushButton(centralwidget);
        btDoIt.setObjectName("btDoIt");

        verticalLayout.addWidget(btDoIt);

        btAdd = new QPushButton(centralwidget);
        btAdd.setObjectName("btAdd");

        verticalLayout.addWidget(btAdd);

        btDel = new QPushButton(centralwidget);
        btDel.setObjectName("btDel");

        verticalLayout.addWidget(btDel);

        graphicsView_2 = new QGraphicsView(centralwidget);
        graphicsView_2.setObjectName("graphicsView_2");

        verticalLayout.addWidget(graphicsView_2);


        gridLayout.addLayout(verticalLayout, 0, 1, 1, 1);

        tableWidget = new QTableWidget(centralwidget);
        tableWidget.setObjectName("tableWidget");
        tableWidget.setColumnCount(3);

        gridLayout.addWidget(tableWidget, 0, 0, 1, 1);

        QtJava.setCentralWidget(centralwidget);
        statusbar = new QStatusBar(QtJava);
        statusbar.setObjectName("statusbar");
        QtJava.setStatusBar(statusbar);
        retranslateUi(QtJava);

        QtJava.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow QtJava)
    {
        QtJava.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("QtJava", "DB", null));
        btDoIt.setText(com.trolltech.qt.core.QCoreApplication.translate("QtJava", "DO IT!", null));
        btAdd.setText(com.trolltech.qt.core.QCoreApplication.translate("QtJava", "Add", null));
        btDel.setText(com.trolltech.qt.core.QCoreApplication.translate("QtJava", "Del", null));
        tableWidget.clear();
        tableWidget.setColumnCount(3);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("QtJava", "ID", null));
        tableWidget.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("QtJava", "Name", null));
        tableWidget.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("QtJava", "Sname", null));
        tableWidget.setHorizontalHeaderItem(2, __colItem2);
        tableWidget.setRowCount(0);
    } // retranslateUi

}

