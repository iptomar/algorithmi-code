/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.editor.center;

import core.data.exception.FlowchartException;
import flowchart.algorithm.Problem;
import flowchart.algorithm.Program;
import flowchart.algorithm.run.GraphExecutor;
import flowchart.utils.image.ImageUtils;
import i18n.EditorI18N;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import ui.dialogs.FMessages;
import ui.flowchart.console.Console;

/**
 *
 * @author zulu
 */
public class ProblemPanel extends javax.swing.JPanel {

    Program myProgram; // editor source code
    Problem myProblem; // editor problem

    /**
     * Creates new form ProblemPanel
     */
    public ProblemPanel() {
        initComponents();
        I18n();
    }

    private void I18n() {

        ((TitledBorder) pnTitle.getBorder()).setTitle(EditorI18N.get("PROBLEM_EDITOR.problem.title"));
        ((TitledBorder) pnDescription.getBorder()).setTitle(EditorI18N.get("PROBLEM_EDITOR.problem.description"));
        ((TitledBorder) pnIO.getBorder()).setTitle(EditorI18N.get("PROBLEM_EDITOR.problem.io"));
        ((TitledBorder) pnInput.getBorder()).setTitle(EditorI18N.get("PROBLEM_EDITOR.problem.input"));
        ((TitledBorder) pnOutput.getBorder()).setTitle(EditorI18N.get("PROBLEM_EDITOR.problem.output"));

        EditorI18N.loadResource(btAddInput, "PROBLEM_EDITOR.problem.input.add", 24);
        EditorI18N.loadResource(btRemoveInput, "PROBLEM_EDITOR.problem.input.remove", 24);
        EditorI18N.loadResource(btTestInput, "PROBLEM_EDITOR.problem.input.test", 24);

    }

    public void updateProblem(Program program) {
        myProgram = program; //editor program
        myProblem = myProgram.myProblem; //editor problem
        //update data
        myProblem.title = txtTitle.getText();
        myProblem.description = txtDescrption.getText();
        myProblem.image = ImageUtils.getJpegByteArray(btImage.getIcon());
        
    }

    public void setProblem(Program program) {
        myProgram = program;
        myProblem = myProgram.myProblem;
        txtTitle.setText(myProblem.title);
        txtDescrption.setText(myProblem.description);
        ImageIcon img;
        try {
            img = ImageUtils.getByteArrayJpeg(myProblem.image);
        } catch (Exception e) {
            img = EditorI18N.loadIcon("APPLICATION.icon", 200);
        }

        img = ImageUtils.resizeProportional(img, 300, 200);
        btImage.setIcon(img);
        updateList();
    }

    private void updateList() {
        DefaultListModel<String> model = new DefaultListModel<>();
        String label = EditorI18N.get("PROBLEM_EDITOR.problem.input.list");
        for (int i = 0; i < myProblem.input.size(); i++) {
            model.addElement(label + " " + i);
        }
        lstInput.setModel(model);
        if (!model.isEmpty()) {
            lstInput.setSelectedIndex(model.size() - 1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnProblem = new javax.swing.JPanel();
        pnIO = new javax.swing.JPanel();
        pnInput = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtInput = new javax.swing.JTextPane();
        pnOutput = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstInput = new javax.swing.JList<String>();
        jPanel1 = new javax.swing.JPanel();
        btAddInput = new javax.swing.JButton();
        btRemoveInput = new javax.swing.JButton();
        btTestInput = new javax.swing.JButton();
        pnTitle = new javax.swing.JPanel();
        txtTitle = new javax.swing.JTextField();
        pnDescription = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtDescrption = new javax.swing.JTextPane();
        btImage = new javax.swing.JButton();
        pnHeader = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        pnProblem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        pnIO.setBorder(javax.swing.BorderFactory.createTitledBorder("Input/output"));

        pnInput.setBorder(javax.swing.BorderFactory.createTitledBorder("input"));
        pnInput.setLayout(new java.awt.BorderLayout());

        txtInput.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jScrollPane5.setViewportView(txtInput);

        pnInput.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        pnOutput.setBorder(javax.swing.BorderFactory.createTitledBorder("output"));
        pnOutput.setLayout(new java.awt.BorderLayout());

        txtOutput.setEditable(false);
        txtOutput.setBackground(new java.awt.Color(0, 0, 0));
        txtOutput.setColumns(20);
        txtOutput.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtOutput.setForeground(new java.awt.Color(255, 255, 255));
        txtOutput.setRows(5);
        jScrollPane2.setViewportView(txtOutput);

        pnOutput.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        lstInput.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lstInput.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstInput.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstInputValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstInput);

        jPanel1.setLayout(new java.awt.GridLayout(0, 1, 3, 3));

        btAddInput.setText("+");
        btAddInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddInputActionPerformed(evt);
            }
        });
        jPanel1.add(btAddInput);

        btRemoveInput.setText("-");
        btRemoveInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveInputActionPerformed(evt);
            }
        });
        jPanel1.add(btRemoveInput);

        btTestInput.setText("test");
        btTestInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTestInputActionPerformed(evt);
            }
        });
        jPanel1.add(btTestInput);

        javax.swing.GroupLayout pnIOLayout = new javax.swing.GroupLayout(pnIO);
        pnIO.setLayout(pnIOLayout);
        pnIOLayout.setHorizontalGroup(
            pnIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnIOLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
        );
        pnIOLayout.setVerticalGroup(
            pnIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnIOLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pnTitle.setBorder(javax.swing.BorderFactory.createTitledBorder("Title"));
        pnTitle.setLayout(new java.awt.BorderLayout());

        txtTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        pnTitle.add(txtTitle, java.awt.BorderLayout.CENTER);

        pnDescription.setBorder(javax.swing.BorderFactory.createTitledBorder("description"));
        pnDescription.setLayout(new java.awt.GridLayout(1, 0));

        txtDescrption.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jScrollPane6.setViewportView(txtDescrption);

        pnDescription.add(jScrollPane6);

        btImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImageActionPerformed(evt);
            }
        });
        pnDescription.add(btImage);

        javax.swing.GroupLayout pnProblemLayout = new javax.swing.GroupLayout(pnProblem);
        pnProblem.setLayout(pnProblemLayout);
        pnProblemLayout.setHorizontalGroup(
            pnProblemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnProblemLayout.setVerticalGroup(
            pnProblemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProblemLayout.createSequentialGroup()
                .addComponent(pnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnProblem, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Web API"));

        jButton1.setText("setProgram");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("program info"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("userinfo"));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(pnHeader, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImageActionPerformed
        ImageIcon img = ImageUtils.selectImageFromFile();
        if (img != null) {
            img = ImageUtils.resizeProportional(img, 300, 200);
            btImage.setIcon(img);
        }
    }//GEN-LAST:event_btImageActionPerformed

    private void btAddInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddInputActionPerformed
        if (!txtInput.getText().isEmpty()) {
            myProblem.input.add(txtInput.getText());
            updateList();
        }
    }//GEN-LAST:event_btAddInputActionPerformed

    private void btRemoveInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveInputActionPerformed
        if (lstInput.getSelectedIndex() >= 0) {
           myProblem.input.remove(lstInput.getSelectedIndex());
            updateList();
        }
    }//GEN-LAST:event_btRemoveInputActionPerformed

    private void lstInputValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstInputValueChanged
        if (lstInput.getSelectedIndex() >= 0) {
            txtInput.setText(myProblem.input.get(lstInput.getSelectedIndex()));
        } else {
            txtInput.setText("");
        }

    }//GEN-LAST:event_lstInputValueChanged

    private void btTestInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTestInputActionPerformed
        if (lstInput.getSelectedIndex() >= 0) {
            try {
                Console console = new Console();
                console.setInput(myProgram.myProblem.input.get(lstInput.getSelectedIndex()));
                GraphExecutor run = new GraphExecutor(myProgram, console);
                while (!run.isDone()) {
                    run.executeFast();
                }
                txtOutput.setText(console.getOutput());
            } catch (FlowchartException ex) {
                FMessages.dialog(FMessages.ERROR, EditorI18N.get("CONSOLE.runtime.error") + "\n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btTestInputActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        myProgram.myProblem.setProgramSolver(myProgram);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddInput;
    private javax.swing.JButton btImage;
    private javax.swing.JButton btRemoveInput;
    private javax.swing.JButton btTestInput;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JList<String> lstInput;
    private javax.swing.JPanel pnDescription;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnIO;
    private javax.swing.JPanel pnInput;
    private javax.swing.JPanel pnOutput;
    private javax.swing.JPanel pnProblem;
    private javax.swing.JPanel pnTitle;
    private javax.swing.JTextPane txtDescrption;
    private javax.swing.JTextPane txtInput;
    private javax.swing.JTextArea txtOutput;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
