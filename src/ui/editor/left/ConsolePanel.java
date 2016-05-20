/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.editor.left;

import core.data.exception.FlowchartException;
import flowchart.algorithm.Program;
import flowchart.algorithm.run.GraphExecutor;
import flowchart.shape.Fshape;
import i18n.EditorI18N;
import i18n.Fi18N;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.dialogs.FMessages;
import ui.editor.Fluxograma;
import ui.editor.run.RunProgram;
import ui.flowchart.console.Console;

import ui.editor.center.ProblemPanel;

/**
 *
 * @author zulu
 */
public class ConsolePanel extends javax.swing.JPanel {

    private Fluxograma myFluxogram;

    /**
     * Creates new form ConsolePanel
     */
    public ConsolePanel() {
        initComponents();
        console.setVerticalOrientation();
        I18N();
    }

    public final void I18N() {

        try {
            EditorI18N.loadResource(btConsoleRun, "CONSOLE.run");
            EditorI18N.loadResource(btConsoleDebug, "CONSOLE.debug");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Consola Erro na leitura da internacionalização");
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

        pnLeftPanelConsoleToolBar = new javax.swing.JPanel();
        btConsoleRun = new javax.swing.JButton();
        btConsoleDebug = new javax.swing.JButton();
        btConsoleEvaluate = new javax.swing.JButton();
        console = new ui.flowchart.console.Console();
        lblConsoleTab = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        btConsoleRun.setText("run");
        btConsoleRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsoleRunActionPerformed(evt);
            }
        });

        btConsoleDebug.setText("debug");
        btConsoleDebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsoleDebugActionPerformed(evt);
            }
        });

        btConsoleEvaluate.setText("evaluate");
        btConsoleEvaluate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsoleEvaluateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnLeftPanelConsoleToolBarLayout = new javax.swing.GroupLayout(pnLeftPanelConsoleToolBar);
        pnLeftPanelConsoleToolBar.setLayout(pnLeftPanelConsoleToolBarLayout);
        pnLeftPanelConsoleToolBarLayout.setHorizontalGroup(
            pnLeftPanelConsoleToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftPanelConsoleToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btConsoleRun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btConsoleDebug)
                .addGap(18, 18, 18)
                .addComponent(btConsoleEvaluate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnLeftPanelConsoleToolBarLayout.setVerticalGroup(
            pnLeftPanelConsoleToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLeftPanelConsoleToolBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnLeftPanelConsoleToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConsoleRun)
                    .addComponent(btConsoleDebug)
                    .addComponent(btConsoleEvaluate))
                .addContainerGap())
        );

        add(pnLeftPanelConsoleToolBar, java.awt.BorderLayout.NORTH);
        add(console, java.awt.BorderLayout.CENTER);

        lblConsoleTab.setText("jLabel5");
        add(lblConsoleTab, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btConsoleRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsoleRunActionPerformed
        tryExecution();
    }//GEN-LAST:event_btConsoleRunActionPerformed

    private void btConsoleDebugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsoleDebugActionPerformed
        if (!compile()) {
            FMessages.dialog(FMessages.ERROR, EditorI18N.get("CONSOLE.compile.error"));
            return;
        }
        Program toRun = myFluxogram.myProgram.getClone();
        new RunProgram(toRun);
    }//GEN-LAST:event_btConsoleDebugActionPerformed

    private void btConsoleEvaluateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsoleEvaluateActionPerformed
        // TODO add your handling code here:
        
        // myFluxogram.myProgram.myProblem.input;
        String myProblemResult=null;

         
        // 2nd solver professor
        //myFluxogram.myProgram.myProblem.solver.fileName.;
        //myFluxogram.myProgram.myProblem.solver.myProblem.input
        String mySolverResult=null;
        
        // 3rd processing input & save output
        // for student solution

//        if (ProblemPanel.lstInput.getSelectedIndex() >= 0) {
//            try {
//                Console consoleMyProblem = new Console();
//                consoleMyProblem.setInput(myFluxogram.myProgram.myProblem.input.get(ProblemPanel.lstInput.getSelectedIndex()));
//                GraphExecutor run = new GraphExecutor(myFluxogram.myProgram, consoleMyProblem);
//                while (!run.isDone()) {
//                    run.executeFast();
//                }
//                myProblemResult=ProblemPanel.txtOutput.setText(consoleMyProblem.getOutput());
//            } catch (FlowchartException ex) {
//                FMessages.dialog(FMessages.ERROR, EditorI18N.get("CONSOLE.runtime.error") + "\n" + ex.getMessage());
//            }
//        }      
//        
        // 3rd processing input & save output
        // for professor solution
        
//        if (lstInput.getSelectedIndex() >= 0) {
//            try {
//                Console console = new Console();
//                console.setInput(solver.myProblem.input.get(lstInput.getSelectedIndex()));
//                GraphExecutor run = new GraphExecutor(solver, console);
//                while (!run.isDone()) {
//                    run.executeFast();
//                }
//                mySolverResult=txtOutput.setText(console.getOutput());
//            } catch (FlowchartException ex) {
//                FMessages.dialog(FMessages.ERROR, EditorI18N.get("CONSOLE.runtime.error") + "\n" + ex.getMessage());
//            }
//        }        
               
        // 3rd compare output evaluate
        
        
    }//GEN-LAST:event_btConsoleEvaluateActionPerformed

    public void tryExecution() {
        if (!compile()) {
            FMessages.dialog(FMessages.ERROR, EditorI18N.get("CONSOLE.compile.error"));
        } else {
            execute();
        }
    }

    public boolean compile() {
        console.clear();
        List<Fshape> errors = myFluxogram.myProgram.compile();
        if (errors.isEmpty()) {
            return true;
        } else {
            for (Fshape error : errors) {
                try {
                    error.parseShape(); // get the exception
                } catch (Exception e) {
                    console.write(e.getMessage());
                }
            }
        }
        return false;
    }

    public void execute() {
        try {
            GraphExecutor run = new GraphExecutor(myFluxogram.myProgram, console);
            while (!run.isDone()) {
                run.executeFast();
            }
        } catch (FlowchartException ex) {
            FMessages.dialog(FMessages.ERROR, EditorI18N.get("CONSOLE.runtime.error") + "\n" + ex.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConsoleDebug;
    private javax.swing.JButton btConsoleEvaluate;
    private javax.swing.JButton btConsoleRun;
    private ui.flowchart.console.Console console;
    private javax.swing.JLabel lblConsoleTab;
    private javax.swing.JPanel pnLeftPanelConsoleToolBar;
    // End of variables declaration//GEN-END:variables

    /**
     * @param myFluxogram the myFluxogram to set
     */
    public void setMyFluxogram(Fluxograma myFluxogram) {
        this.myFluxogram = myFluxogram;
    }
    
//    /**
//     * @param myFluxogram the myFluxogram to get
//     */
//    public Fluxograma getMyFluxogram() {
//        return myFluxogram;
//    }
  
}
