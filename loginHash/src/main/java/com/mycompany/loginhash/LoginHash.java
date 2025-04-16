/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginhash;

import com.mycompany.loginhash.dao.UsuarioDAO;
import com.mycompany.loginhash.database.ConnectionSQL;
import com.mycompany.loginhash.model.Usuario;
import com.mycompany.loginhash.view.TelaLogin;

/**
 *
 * @author Aluno
 */
public class LoginHash {

    public static void main(String[] args) {
        ConnectionSQL.conectar();
        
        Usuario usuario = new Usuario("mai1","senha123");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.registrarUsuario(usuario);
        usuarioDAO.validarLogin(usuario);
        usuarioDAO.buscarUsuarioPorEmail(usuario.getEmail());
        new TelaLogin().setVisible(true);
        
    }
}
