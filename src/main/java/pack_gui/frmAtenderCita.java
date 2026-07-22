/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pack_gui;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import java.awt.Component;
import pack_estructuras.*;

/**
 *
 * @author USUARIO
 */
public class frmAtenderCita extends javax.swing.JFrame {
    
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmAtenderCita.class.getName());


    private String idCita;
    private String nombrePaciente;
    
    // Pila donde se van guardando los medicamentos que el doctor agrega en la consulta
    // sirve para poder deshacer el ultimo ingreso si el doctor se equivoca
    private Pila<String[]> medicinas; 
    
    // Esta bandera le avisa a la ventana del doctor si la cita realmente se atendio o se cancelo
    private boolean citaAtendida = false; 
    private String estadoCita = "";

    
        /**
     * Creates new form frmAtenderCita
     */
    public frmAtenderCita(String idCita, String nombrePaciente) {
        this.idCita = idCita;
        this.nombrePaciente = nombrePaciente;
        this.medicinas = new Pila<>();
        initComponents();
        lIdCita.setText("ID Cita: " + idCita);
        lPaciente.setText("Paciente: " + nombrePaciente);
    }

    // Genera un archivo de texto con el resumen completo de la consulta
    // el nombre del archivo lleva la fecha y hora para que no se sobrescriba con otro
    private void generarArchivoConsulta() {
    try {
        String nombreArchivo = String.format("Consulta_%s_%s.txt", 
            this.idCita, 
            new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date()));
        
        try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(nombreArchivo))) {
            pw.println("═══════════════════════════════════════════════════════════");
            pw.println("              REGISTRO DE CONSULTA MÉDICA");
            pw.println("═══════════════════════════════════════════════════════════");
            pw.println();
            
            pw.println("ID CITA: " + this.idCita);
            pw.println("PACIENTE: " + this.nombrePaciente);
            pw.println("FECHA DE REGISTRO: " + new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date()));
            pw.println();
            
            pw.println("───────────────────────────────────────────────────────────");
            pw.println("INFORMACIÓN CLÍNICA");
            pw.println("───────────────────────────────────────────────────────────");
            pw.println();
            
            pw.println("GRAVEDAD: " + cmbGravedad.getSelectedItem());
            pw.println();
            
            pw.println("DIAGNÓSTICO:");
            pw.println(txtDiagnostico.getText().trim());
            pw.println();
            
            pw.println("TRATAMIENTO:");
            pw.println(txtTratamiento.getText().trim());
            pw.println();
            
            pw.println("DURACIÓN DEL TRATAMIENTO: " + spnDuracion.getValue() + " días");
            pw.println();
            
            javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tablaMedicinas.getModel();
            if (chkReceta.isSelected() && modelo.getRowCount() > 0) {
                pw.println("───────────────────────────────────────────────────────────");
                pw.println("PRESCRIPCIÓN DE MEDICAMENTOS");
                pw.println("───────────────────────────────────────────────────────────");
                pw.println();
                
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    String med = modelo.getValueAt(i, 0).toString();
                    String dosis = modelo.getValueAt(i, 1).toString();
                    String indic = modelo.getValueAt(i, 2).toString();
                    
                    pw.println((i + 1) + ". " + med);
                    pw.println("   Dosis: " + dosis);
                    pw.println("   Indicaciones: " + indic);
                    pw.println();
                }
            } else {
                pw.println("No se prescribieron medicamentos.");
                pw.println();
            }
            
            pw.println("═══════════════════════════════════════════════════════════");
            pw.println("           Fin del Registro de Consulta");
            pw.println("═══════════════════════════════════════════════════════════");
        }
        
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Archivo generado exitosamente:\n" + nombreArchivo,
            "Archivo Creado", 
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
    } catch (java.io.IOException e) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Error al generar el archivo: " + e.getMessage(),
            "Error",
            javax.swing.JOptionPane.ERROR_MESSAGE);
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

        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        pEncabezadoACM = new javax.swing.JPanel();
        lAtencionConsultaM = new javax.swing.JLabel();
        lIdCita = new javax.swing.JLabel();
        lPaciente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        pPrincipalACM = new javax.swing.JPanel();
        jGravedad = new javax.swing.JLabel();
        cmbGravedad = new javax.swing.JComboBox<>();
        jDiagnostico = new javax.swing.JLabel();
        scrpDiagnostico = new javax.swing.JScrollPane();
        txtDiagnostico = new javax.swing.JTextArea();
        lTratamiento = new javax.swing.JLabel();
        scrpTratamiento = new javax.swing.JScrollPane();
        txtTratamiento = new javax.swing.JTextArea();
        lDuracion = new javax.swing.JLabel();
        spnDuracion = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        chkReceta = new javax.swing.JCheckBox();
        lMedicamento = new javax.swing.JLabel();
        txtMedicamento = new javax.swing.JTextField();
        lDosis = new javax.swing.JLabel();
        txtDosis = new javax.swing.JTextField();
        lIndicaciones = new javax.swing.JLabel();
        txtIndicaciones = new javax.swing.JTextField();
        btnAgregarMedicina = new javax.swing.JButton();
        scrpMedicamentos = new javax.swing.JScrollPane();
        tablaMedicinas = new javax.swing.JTable();
        btnDeshacerUltimoIngreso = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNoSePresento = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Atender Cita");
        setPreferredSize(new java.awt.Dimension(850, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pEncabezadoACM.setBackground(new java.awt.Color(70, 130, 180));
        pEncabezadoACM.setMinimumSize(new java.awt.Dimension(760, 120));
        pEncabezadoACM.setPreferredSize(new java.awt.Dimension(760, 120));
        pEncabezadoACM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lAtencionConsultaM.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lAtencionConsultaM.setForeground(new java.awt.Color(255, 255, 255));
        lAtencionConsultaM.setText("ATENCIÓN DE CONSULTA MÉDICA");
        lAtencionConsultaM.setPreferredSize(new java.awt.Dimension(500, 27));
        pEncabezadoACM.add(lAtencionConsultaM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, -1, -1));

        lIdCita.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lIdCita.setForeground(new java.awt.Color(255, 255, 255));
        lIdCita.setText("ID Cita: ");
        lIdCita.setPreferredSize(new java.awt.Dimension(300, 25));
        pEncabezadoACM.add(lIdCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lPaciente.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lPaciente.setForeground(new java.awt.Color(255, 255, 255));
        lPaciente.setText("Paciente: ");
        lPaciente.setPreferredSize(new java.awt.Dimension(500, 22));
        pEncabezadoACM.add(lPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        getContentPane().add(pEncabezadoACM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, -1));
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 100, -1));

        pPrincipalACM.setBackground(new java.awt.Color(255, 255, 255));
        pPrincipalACM.setPreferredSize(new java.awt.Dimension(740, 600));
        pPrincipalACM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jGravedad.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jGravedad.setText("Gravedad: ");
        jGravedad.setPreferredSize(new java.awt.Dimension(100, 25));
        pPrincipalACM.add(jGravedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, -1, -1));

        cmbGravedad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Leve", "Moderada", "Grave", "Crítica" }));
        cmbGravedad.setPreferredSize(new java.awt.Dimension(150, 25));
        pPrincipalACM.add(cmbGravedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 15, 160, -1));

        jDiagnostico.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jDiagnostico.setText("Diagnóstico: ");
        jDiagnostico.setPreferredSize(new java.awt.Dimension(120, 25));
        pPrincipalACM.add(jDiagnostico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        scrpDiagnostico.setPreferredSize(new java.awt.Dimension(700, 70));

        txtDiagnostico.setColumns(20);
        txtDiagnostico.setRows(3);
        scrpDiagnostico.setViewportView(txtDiagnostico);

        pPrincipalACM.add(scrpDiagnostico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 75, -1, -1));

        lTratamiento.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lTratamiento.setText("Tratamiento: ");
        lTratamiento.setPreferredSize(new java.awt.Dimension(120, 25));
        pPrincipalACM.add(lTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, -1, -1));

        scrpTratamiento.setPreferredSize(new java.awt.Dimension(700, 70));

        txtTratamiento.setColumns(20);
        txtTratamiento.setRows(3);
        scrpTratamiento.setViewportView(txtTratamiento);

        pPrincipalACM.add(scrpTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        lDuracion.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lDuracion.setText("Duración (días): ");
        lDuracion.setPreferredSize(new java.awt.Dimension(120, 25));
        pPrincipalACM.add(lDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        spnDuracion.setModel(new javax.swing.SpinnerNumberModel(7, 1, 365, 1));
        spnDuracion.setPreferredSize(new java.awt.Dimension(80, 25));
        pPrincipalACM.add(spnDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 80, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("PRESCRIPCIÓN DE MEDICAMENTOS: ");
        jLabel7.setPreferredSize(new java.awt.Dimension(500, 25));
        pPrincipalACM.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 270, -1));

        chkReceta.setText("Preescribir Medicamentos");
        chkReceta.setPreferredSize(new java.awt.Dimension(200, 25));
        chkReceta.addActionListener(this::chkRecetaActionPerformed);
        pPrincipalACM.add(chkReceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        lMedicamento.setText("Medicamento: ");
        lMedicamento.setPreferredSize(new java.awt.Dimension(100, 25));
        pPrincipalACM.add(lMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 365, -1, -1));

        txtMedicamento.setEnabled(false);
        txtMedicamento.setPreferredSize(new java.awt.Dimension(200, 25));
        pPrincipalACM.add(txtMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 365, -1, -1));

        lDosis.setText("Dosis: ");
        lDosis.setPreferredSize(new java.awt.Dimension(50, 25));
        pPrincipalACM.add(lDosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 365, -1, -1));

        txtDosis.setEnabled(false);
        txtDosis.setPreferredSize(new java.awt.Dimension(150, 25));
        pPrincipalACM.add(txtDosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 365, -1, -1));

        lIndicaciones.setText("Indicaciones: ");
        lIndicaciones.setPreferredSize(new java.awt.Dimension(100, 25));
        pPrincipalACM.add(lIndicaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        txtIndicaciones.setEnabled(false);
        txtIndicaciones.setPreferredSize(new java.awt.Dimension(400, 25));
        pPrincipalACM.add(txtIndicaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, -1, -1));

        btnAgregarMedicina.setBackground(new java.awt.Color(60, 179, 113));
        btnAgregarMedicina.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarMedicina.setText("Agregar");
        btnAgregarMedicina.setEnabled(false);
        btnAgregarMedicina.setFocusPainted(false);
        btnAgregarMedicina.setPreferredSize(new java.awt.Dimension(90, 23));
        btnAgregarMedicina.addActionListener(this::btnAgregarMedicinaActionPerformed);
        pPrincipalACM.add(btnAgregarMedicina, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, -1, -1));

        scrpMedicamentos.setPreferredSize(new java.awt.Dimension(700, 120));

        tablaMedicinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicamento", "Dosis", "Indicaciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrpMedicamentos.setViewportView(tablaMedicinas);

        pPrincipalACM.add(scrpMedicamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 435, -1, -1));

        btnDeshacerUltimoIngreso.setBackground(new java.awt.Color(220, 20, 60));
        btnDeshacerUltimoIngreso.setForeground(new java.awt.Color(255, 255, 255));
        btnDeshacerUltimoIngreso.setText("Deshacer Ultimo Ingreso");
        btnDeshacerUltimoIngreso.setEnabled(false);
        btnDeshacerUltimoIngreso.setFocusPainted(false);
        btnDeshacerUltimoIngreso.setPreferredSize(new java.awt.Dimension(90, 23));
        btnDeshacerUltimoIngreso.addActionListener(this::btnDeshacerUltimoIngresoActionPerformed);
        pPrincipalACM.add(btnDeshacerUltimoIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 180, -1));

        btnCancelar.setBackground(new java.awt.Color(220, 20, 60));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusPainted(false);
        btnCancelar.setPreferredSize(new java.awt.Dimension(131, 27));
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        pPrincipalACM.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, 100, 30));

        btnNoSePresento.setBackground(new java.awt.Color(255, 140, 0));
        btnNoSePresento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNoSePresento.setForeground(new java.awt.Color(255, 255, 255));
        btnNoSePresento.setText("No se presentó");
        btnNoSePresento.setFocusPainted(false);
        btnNoSePresento.addActionListener(this::btnNoSePresentoActionPerformed);
        pPrincipalACM.add(btnNoSePresento, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 560, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(60, 179, 113));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        pPrincipalACM.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 560, -1, -1));

        jScrollPane4.setViewportView(pPrincipalACM);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 830, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Si el doctor no va a recetar nada, se bloquean los campos de medicamento
    private void chkRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkRecetaActionPerformed
        // TODO add your handling code here:
    boolean habilitado = chkReceta.isSelected();
    txtMedicamento.setEnabled(habilitado);
    txtDosis.setEnabled(habilitado);
    txtIndicaciones.setEnabled(habilitado);
    btnAgregarMedicina.setEnabled(habilitado);
    btnDeshacerUltimoIngreso.setEnabled(habilitado);
    }//GEN-LAST:event_chkRecetaActionPerformed

    // La dosis tiene que ser un numero valido y mayor o igual a 1
    private void btnAgregarMedicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMedicinaActionPerformed
        // TODO add your handling code here:
    String medicamento = txtMedicamento.getText().trim();
    String dosis = txtDosis.getText().trim();
    String indicaciones = txtIndicaciones.getText().trim();
    
    if (medicamento.isEmpty() || dosis.isEmpty() || indicaciones.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Complete todos los campos del medicamento");
        return;
    }
    
    // Validar que la dosis sea un número mayor a 1
    try {
        int valorDosis = Integer.parseInt(dosis);
        if (valorDosis < 1) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "La dosis debe ser un número mayor o igual a 1", 
                "Error de validación", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
            txtDosis.requestFocus();
            return;
        }
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "La dosis debe ser un número válido", 
            "Error de validación", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
        txtDosis.requestFocus();
        return;
    }
    
    String[] nuevaMedicina = {medicamento, dosis, indicaciones};
    // Se guarda el medicamento en la pila y tambien en la tabla que se ve en pantalla
    medicinas.apilar(nuevaMedicina);
    
    javax.swing.table.DefaultTableModel modelo = 
        (javax.swing.table.DefaultTableModel) tablaMedicinas.getModel();
    modelo.addRow(new Object[]{medicamento, dosis, indicaciones});

    
    
    // Limpiar campos
    txtMedicamento.setText("");
    txtDosis.setText("");
    txtIndicaciones.setText("");
    txtMedicamento.requestFocus();
    
    }//GEN-LAST:event_btnAgregarMedicinaActionPerformed

    // Como es una pila, siempre se elimina el ultimo medicamento agregado, nunca uno al azar
    private void btnDeshacerUltimoIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerUltimoIngresoActionPerformed
        // TODO add your handling code here:
        //Validar si la pila de medicinas está vacía
        if (medicinas.estaVacia()) {
                javax.swing.JOptionPane.showMessageDialog(this, "No hay medicamentos recientes para deshacer.");
                return;
        }
        //Desapilar ese último ingreso
        medicinas.desapilar();

        javax.swing.table.DefaultTableModel modelo = 
                (javax.swing.table.DefaultTableModel) tablaMedicinas.getModel();
        //Eliminar de la parte gráfica
        int ultimaFila = modelo.getRowCount() - 1;
            modelo.removeRow(ultimaFila);
    }//GEN-LAST:event_btnDeshacerUltimoIngresoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        citaAtendida = false;
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNoSePresentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoSePresentoActionPerformed
        // TODO add your handling code here:
    int respuesta = javax.swing.JOptionPane.showConfirmDialog(this, 
        "¿Confirma que el paciente no se presentó a la cita?", 
        "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
    
    if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
        citaAtendida = true;
        estadoCita = "No se presentó";
        javax.swing.JOptionPane.showMessageDialog(this, "Cita marcada como 'No se presentó'");
        dispose();
    }
    }//GEN-LAST:event_btnNoSePresentoActionPerformed

    // Cada medicamento recetado se guarda en recetas.csv como Pendiente
    // asi despues el farmaceutico lo puede ver y despachar
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    if (txtDiagnostico.getText().trim().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar un diagnóstico");
        return;
    }

    if (txtTratamiento.getText().trim().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar el tratamiento");
        return;
    }

    String archivoRecetas = "recetas.csv";
    
    StringBuilder mensaje = new StringBuilder("CONSULTA REGISTRADA\n\n");
    mensaje.append("Gravedad: ").append(cmbGravedad.getSelectedItem()).append("\n");
    mensaje.append("Duración: ").append(spnDuracion.getValue()).append(" días\n");

    try (java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter(archivoRecetas, true))) {
        
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tablaMedicinas.getModel();
        
        if (chkReceta.isSelected() && modelo.getRowCount() > 0) {
            mensaje.append("\nMedicamentos prescritos:\n");
            
            for (int i = 0; i < modelo.getRowCount(); i++) {
                String med = modelo.getValueAt(i, 0).toString();
                String dosis = modelo.getValueAt(i, 1).toString();
                String indic = modelo.getValueAt(i, 2).toString();
                
                String linea = String.format("%s,%s,%s,%s,%s", 
                        this.idCita, this.nombrePaciente, med, dosis, "Pendiente");
                bw.write(linea);
                bw.newLine();
                
                mensaje.append("  • ").append(med).append(" - ").append(dosis)
                       .append(" (").append(indic).append(")\n");
            }
        }

        // Se marca la cita como atendida antes de generar el archivo y cerrar la ventana
        citaAtendida = true;
        estadoCita = "Atendida";
        
        generarArchivoConsulta();

        javax.swing.JOptionPane.showMessageDialog(this, mensaje.toString(), 
            "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        dispose();

    } catch (java.io.IOException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al guardar la receta: " + e.getMessage());
    }
   
    }//GEN-LAST:event_btnGuardarActionPerformed

    // Estos dos metodos los usa frmMedico para saber que paso con la cita despues de cerrar esta ventana
    public boolean isCitaAtendida() {
        return citaAtendida;
    }
    
    public String getEstadoCita() {
        return estadoCita;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(frmAtenderCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> new frmAtenderCita("C001", "Juan Pérez").setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMedicina;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeshacerUltimoIngreso;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNoSePresento;
    private javax.swing.JCheckBox chkReceta;
    private javax.swing.JComboBox<String> cmbGravedad;
    private javax.swing.JLabel jDiagnostico;
    private javax.swing.JLabel jGravedad;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lAtencionConsultaM;
    private javax.swing.JLabel lDosis;
    private javax.swing.JLabel lDuracion;
    private javax.swing.JLabel lIdCita;
    private javax.swing.JLabel lIndicaciones;
    private javax.swing.JLabel lMedicamento;
    private javax.swing.JLabel lPaciente;
    private javax.swing.JLabel lTratamiento;
    private javax.swing.JPanel pEncabezadoACM;
    private javax.swing.JPanel pPrincipalACM;
    private javax.swing.JScrollPane scrpDiagnostico;
    private javax.swing.JScrollPane scrpMedicamentos;
    private javax.swing.JScrollPane scrpTratamiento;
    private javax.swing.JSpinner spnDuracion;
    private javax.swing.JTable tablaMedicinas;
    private javax.swing.JTextArea txtDiagnostico;
    private javax.swing.JTextField txtDosis;
    private javax.swing.JTextField txtIndicaciones;
    private javax.swing.JTextField txtMedicamento;
    private javax.swing.JTextArea txtTratamiento;
    // End of variables declaration//GEN-END:variables
}
