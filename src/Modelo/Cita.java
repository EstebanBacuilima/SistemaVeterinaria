/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author ediss
 */
public class Cita {
    private int id;
    private int id_dueño;
    private String ced_dueño;
    private String nom_dueño;
    private int id_paciente;
    private String nom_paciente;
    private int id_servicio;
    private String nom_servicio;
    private int id_veterinario;
    private String nom_veterinario;
    private int id_consultorio;
    private String nom_consultorio;
    private int id_secretaria;
    private LocalDate fecha;
    private String hora_ini;
    private String estado;
    private int id_factura;

    public Cita() {
    }

    public Cita(int id, int id_dueño, String ced_dueño, String nom_dueño, int id_paciente, String nom_paciente, int id_servicio, String nom_servicio, int id_veterinario, String nom_veterinario, int id_consultorio, String nom_consultorio, int id_secretaria, LocalDate fecha, String hora_ini, String estado, int id_factura) {
        this.id = id;
        this.id_dueño = id_dueño;
        this.ced_dueño = ced_dueño;
        this.nom_dueño = nom_dueño;
        this.id_paciente = id_paciente;
        this.nom_paciente = nom_paciente;
        this.id_servicio = id_servicio;
        this.nom_servicio = nom_servicio;
        this.id_veterinario = id_veterinario;
        this.nom_veterinario = nom_veterinario;
        this.id_consultorio = id_consultorio;
        this.nom_consultorio = nom_consultorio;
        this.id_secretaria = id_secretaria;
        this.fecha = fecha;
        this.hora_ini = hora_ini;
        this.estado = estado;
        this.id_factura = id_factura;
    }

    

    public Cita(int id, int id_servicio, String nom_servicio, LocalDate fecha) {
        this.id = id;
        this.id_servicio = id_servicio;
        this.nom_servicio = nom_servicio;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_dueño() {
        return id_dueño;
    }

    public void setId_dueño(int id_dueño) {
        this.id_dueño = id_dueño;
    }

    public String getCed_dueño() {
        return ced_dueño;
    }

    public void setCed_dueño(String ced_dueño) {
        this.ced_dueño = ced_dueño;
    }

    public String getNom_dueño() {
        return nom_dueño;
    }

    public void setNom_dueño(String nom_dueño) {
        this.nom_dueño = nom_dueño;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNom_paciente() {
        return nom_paciente;
    }

    public void setNom_paciente(String nom_paciente) {
        this.nom_paciente = nom_paciente;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNom_servicio() {
        return nom_servicio;
    }

    public void setNom_servicio(String nom_servicio) {
        this.nom_servicio = nom_servicio;
    }

    public int getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(int id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public String getNom_veterinario() {
        return nom_veterinario;
    }

    public void setNom_veterinario(String nom_veterinario) {
        this.nom_veterinario = nom_veterinario;
    }

    public int getId_consultorio() {
        return id_consultorio;
    }

    public void setId_consultorio(int id_consultorio) {
        this.id_consultorio = id_consultorio;
    }

    public String getNom_consultorio() {
        return nom_consultorio;
    }

    public void setNom_consultorio(String nom_consultorio) {
        this.nom_consultorio = nom_consultorio;
    }

    public int getId_secretaria() {
        return id_secretaria;
    }

    public void setId_secretaria(int id_secretaria) {
        this.id_secretaria = id_secretaria;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora_ini() {
        return hora_ini;
    }

    public void setHora_ini(String hora_ini) {
        this.hora_ini = hora_ini;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }
    



}