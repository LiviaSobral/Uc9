/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginhash.controller;

import com.mycompany.loginhash.dao.UsuarioDAO;
import com.mycompany.loginhash.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aluno
 */
public class UsuarioController {
    private static UsuarioDAO dAO = new UsuarioDAO();
    
    public static Usuario verificarUsuario(String email,char[] charSenha){
        String senha = new String(charSenha);
        Usuario usuario = new Usuario(email,senha);
        if(dAO.validarLogin(usuario)){
            return usuario;
        }
        return null;
        
        
    }
    
    public static boolean registrarUsuario(String email,char[] charSenha){
        String senha = new String(charSenha);
        Usuario usuario = new Usuario(email,senha);
        return dAO.registrarUsuario(usuario);
    }
    
    public static boolean excluirUsuario(Usuario usuario){
        return dAO.excluirUsuario(usuario.getEmail());
        
    }
    
    public static void listarUsuarios(DefaultTableModel model){
        ArrayList<Usuario> usuarios = dAO.listarUsuarios();
        model.setRowCount(0);
        for(Usuario user : usuarios){
            model.addRow(new Object[]{user.getId(),user.getEmail()});
        }
    }
    
    public static Usuario buscarUsuarioPorEmail(String email){        
        return dAO.buscarUsuarioPorEmail(email);
    }
    
    public static boolean atualizarUsuario(Usuario usuario,char[] senhaChar){
        String senha = new String(senhaChar);
        return dAO.atualizarSenha(usuario.getEmail(), senha);                    
    }
    
}
