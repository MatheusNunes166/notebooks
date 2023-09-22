package com.controlle.notebooks.Service;

import com.controlle.notebooks.Model.M_Usuario;
import com.controlle.notebooks.Repository.R_Usuario;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
public class S_Usuario {
    private  static R_Usuario r_usuario;

    public S_Usuario(R_Usuario r_usuario){
        this.r_usuario = r_usuario;
    }

    public static String cadastrarUsuario(String nome, String cargo, String matricula, String email) {
        boolean podeSalvar = true;
        String mensagem = "";

        if (S_Generico.textoEstaVazio(nome)) {
            podeSalvar = false;
            mensagem += "nome nao preenchido";
        }

        if (!S_Generico.validarEmail(email)) {
            podeSalvar = false;
            mensagem += "email nao preenchido e invalido";
        }

        if (S_Generico.textoEstaVazio(S_Generico.limparNumero((matricula)))) {
            podeSalvar = false;
            mensagem += "matricula nao preenchido";
        }

        if (S_Generico.textoEstaVazio(S_Generico.limparNumero((cargo)))) {
            podeSalvar = false;
            mensagem += "cargo nao preenchido";
        }

        if (podeSalvar) {
            M_Usuario m_usuario = new M_Usuario();
            m_usuario.setNome(nome);
            m_usuario.setEmail(email);
            m_usuario.setMatricula(Long.parseLong(matricula));
            m_usuario.setCargo(Long.parseLong(cargo));
            m_usuario.setSenha(S_GeratorSenha.gerarSenha());
            try {
                r_usuario.save(m_usuario);
                mensagem += "Deu bom";
            } catch (DataIntegrityViolationException e) {
                mensagem += "Deu ruim";
            }
        }
        return mensagem;
    }
}