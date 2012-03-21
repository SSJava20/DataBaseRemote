package org.courses;
/********************************************************************************
 ** Form generated from reading ui file 'PersonEditDialog.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.7.0
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_PersonEditDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QVBoxLayout verticalLayout;
    public QHBoxLayout horizontalLayout;
    public QLabel lblName;
    public QSpacerItem horizontalSpacer;
    public QLineEdit leName;
    public QHBoxLayout horizontalLayout_2;
    public QLabel lblSName;
    public QSpacerItem horizontalSpacer_2;
    public QLineEdit leSName;
    public QHBoxLayout horizontalLayout_3;
    public QLabel lblPhone;
    public QSpacerItem horizontalSpacer_3;
    public QLineEdit lePhone;
    public QHBoxLayout horizontalLayout_4;
    public QLabel lblMail;
    public QSpacerItem horizontalSpacer_4;
    public QLineEdit leMail;
    public QHBoxLayout horizontalLayout_5;
    public QLabel lblBirthday;
    public QSpacerItem horizontalSpacer_5;
    public QDateEdit dateEdit;
    public QHBoxLayout horizontalLayout_6;
    public QLabel lblInfo;
    public QSpacerItem horizontalSpacer_6;
    public QTextEdit tePetsonInfo;
    public QHBoxLayout horizontalLayout_8;
    public QLabel lbllblInfo;
    public QSpacerItem horizontalSpacer_9;
    public QPushButton pbSetImage;
    public QLabel lblImage;
    public QHBoxLayout horizontalLayout_7;
    public QLabel lblFile;
    public QSpacerItem horizontalSpacer_7;
    public QPushButton btSetFile;
    public QSpacerItem horizontalSpacer_8;
    public QPushButton btGetFile;
    public QDialogButtonBox buttonBox;

    public Ui_PersonEditDialog() { super(); }

    public void setupUi(QDialog PersonEditDialog)
    {
        PersonEditDialog.setObjectName("PersonEditDialog");
        PersonEditDialog.resize(new QSize(467, 557).expandedTo(PersonEditDialog.minimumSizeHint()));
        verticalLayout = new QVBoxLayout(PersonEditDialog);
        verticalLayout.setObjectName("verticalLayout");
        horizontalLayout = new QHBoxLayout();
        horizontalLayout.setObjectName("horizontalLayout");
        lblName = new QLabel(PersonEditDialog);
        lblName.setObjectName("lblName");

        horizontalLayout.addWidget(lblName);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(horizontalSpacer);

        leName = new QLineEdit(PersonEditDialog);
        leName.setObjectName("leName");

        horizontalLayout.addWidget(leName);


        verticalLayout.addLayout(horizontalLayout);

        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2.setObjectName("horizontalLayout_2");
        lblSName = new QLabel(PersonEditDialog);
        lblSName.setObjectName("lblSName");

        horizontalLayout_2.addWidget(lblSName);

        horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_2.addItem(horizontalSpacer_2);

        leSName = new QLineEdit(PersonEditDialog);
        leSName.setObjectName("leSName");

        horizontalLayout_2.addWidget(leSName);


        verticalLayout.addLayout(horizontalLayout_2);

        horizontalLayout_3 = new QHBoxLayout();
        horizontalLayout_3.setObjectName("horizontalLayout_3");
        lblPhone = new QLabel(PersonEditDialog);
        lblPhone.setObjectName("lblPhone");

        horizontalLayout_3.addWidget(lblPhone);

        horizontalSpacer_3 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_3.addItem(horizontalSpacer_3);

        lePhone = new QLineEdit(PersonEditDialog);
        lePhone.setObjectName("lePhone");

        horizontalLayout_3.addWidget(lePhone);


        verticalLayout.addLayout(horizontalLayout_3);

        horizontalLayout_4 = new QHBoxLayout();
        horizontalLayout_4.setObjectName("horizontalLayout_4");
        lblMail = new QLabel(PersonEditDialog);
        lblMail.setObjectName("lblMail");

        horizontalLayout_4.addWidget(lblMail);

        horizontalSpacer_4 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_4.addItem(horizontalSpacer_4);

        leMail = new QLineEdit(PersonEditDialog);
        leMail.setObjectName("leMail");

        horizontalLayout_4.addWidget(leMail);


        verticalLayout.addLayout(horizontalLayout_4);

        horizontalLayout_5 = new QHBoxLayout();
        horizontalLayout_5.setObjectName("horizontalLayout_5");
        lblBirthday = new QLabel(PersonEditDialog);
        lblBirthday.setObjectName("lblBirthday");

        horizontalLayout_5.addWidget(lblBirthday);

        horizontalSpacer_5 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_5.addItem(horizontalSpacer_5);

        dateEdit = new QDateEdit(PersonEditDialog);
        dateEdit.setObjectName("dateEdit");

        horizontalLayout_5.addWidget(dateEdit);


        verticalLayout.addLayout(horizontalLayout_5);

        horizontalLayout_6 = new QHBoxLayout();
        horizontalLayout_6.setObjectName("horizontalLayout_6");
        lblInfo = new QLabel(PersonEditDialog);
        lblInfo.setObjectName("lblInfo");

        horizontalLayout_6.addWidget(lblInfo);

        horizontalSpacer_6 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_6.addItem(horizontalSpacer_6);

        tePetsonInfo = new QTextEdit(PersonEditDialog);
        tePetsonInfo.setObjectName("tePetsonInfo");
        tePetsonInfo.setMinimumSize(new QSize(1, 0));

        horizontalLayout_6.addWidget(tePetsonInfo);


        verticalLayout.addLayout(horizontalLayout_6);

        horizontalLayout_8 = new QHBoxLayout();
        horizontalLayout_8.setObjectName("horizontalLayout_8");
        lbllblInfo = new QLabel(PersonEditDialog);
        lbllblInfo.setObjectName("lbllblInfo");

        horizontalLayout_8.addWidget(lbllblInfo);

        horizontalSpacer_9 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_8.addItem(horizontalSpacer_9);

        pbSetImage = new QPushButton(PersonEditDialog);
        pbSetImage.setObjectName("pbSetImage");

        horizontalLayout_8.addWidget(pbSetImage);

        lblImage = new QLabel(PersonEditDialog);
        lblImage.setObjectName("lblImage");
        lblImage.setMinimumSize(new QSize(200, 200));

        horizontalLayout_8.addWidget(lblImage);


        verticalLayout.addLayout(horizontalLayout_8);

        horizontalLayout_7 = new QHBoxLayout();
        horizontalLayout_7.setObjectName("horizontalLayout_7");
        lblFile = new QLabel(PersonEditDialog);
        lblFile.setObjectName("lblFile");

        horizontalLayout_7.addWidget(lblFile);

        horizontalSpacer_7 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_7.addItem(horizontalSpacer_7);

        btSetFile = new QPushButton(PersonEditDialog);
        btSetFile.setObjectName("btSetFile");

        horizontalLayout_7.addWidget(btSetFile);

        horizontalSpacer_8 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_7.addItem(horizontalSpacer_8);

        btGetFile = new QPushButton(PersonEditDialog);
        btGetFile.setObjectName("btGetFile");

        horizontalLayout_7.addWidget(btGetFile);


        verticalLayout.addLayout(horizontalLayout_7);

        buttonBox = new QDialogButtonBox(PersonEditDialog);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));

        verticalLayout.addWidget(buttonBox);

        retranslateUi(PersonEditDialog);
        buttonBox.accepted.connect(PersonEditDialog, "accept()");
        buttonBox.rejected.connect(PersonEditDialog, "reject()");

        PersonEditDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog PersonEditDialog)
    {
        PersonEditDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("PersonEditDialog", "Person", null));
        lblName.setText(com.trolltech.qt.core.QCoreApplication.translate("PersonEditDialog", "Name", null));
        lblSName.setText(com.trolltech.qt.core.QCoreApplication.translate("PersonEditDialog", "Second Name", null));
        lblPhone.setText(com.trolltech.qt.core.QCoreApplication.translate("PersonEditDialog", "Phone", null));
        lblMail.setText(com.trolltech.qt.core.QCoreApplication.translate("PersonEditDialog", "Mail", null));
        lblBirthday.setText(com.trolltech.qt.core.QCoreApplication.translate("PersonEditDialog", "Birthday", null));
        lblInfo.setText(com.trolltech.qt.core.QCoreApplication.translate("PersonEditDialog", "Info", null));
        lbllblInfo.setText(com.trolltech.qt.core.QCoreApplication.translate("PersonEditDialog", "Image", null));
        pbSetImage.setText(com.trolltech.qt.core.QCoreApplication.translate("PersonEditDialog", "Set", null));
        lblImage.setText("");
        lblFile.setText(com.trolltech.qt.core.QCoreApplication.translate("PersonEditDialog", "File", null));
        btSetFile.setText(com.trolltech.qt.core.QCoreApplication.translate("PersonEditDialog", "Set", null));
        btGetFile.setText(com.trolltech.qt.core.QCoreApplication.translate("PersonEditDialog", "Get", null));
    } // retranslateUi

}

