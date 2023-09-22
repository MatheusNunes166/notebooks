package com.controlle.notebooks.Service;

import com.controlle.notebooks.Model.M_Notebook;
import com.controlle.notebooks.Repository.R_Notebook;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class S_Notebook {
    private static R_Notebook r_notebook;
    public S_Notebook(R_Notebook r_notebook){
        this.r_notebook = r_notebook;
    }
    public  static String cadastrarNotebook(String numero,String patrimonio ){
        boolean podeSalvar = true;
        String mensagem = "";

        if (S_Generico.textoEstaVazio(S_Generico.limparNumero(numero))) {
            podeSalvar = false;
            mensagem += "numero nao preenchido";
        }

        if (!S_Generico.textoEstaVazio(S_Generico.limparNumero(patrimonio))) {
            podeSalvar = false;
            mensagem += "\nO numero do patrimonio deve ser informado";
        }
        if (podeSalvar) {
            M_Notebook m_notebook = new M_Notebook();
            m_notebook.setNumero(Integer.parseInt(numero));
            m_notebook.setPatrimonio(Long.parseLong(patrimonio));
            m_notebook.setAtivo(true);
            try {
                r_notebook.save(m_notebook);
                mensagem += "Deu bom";
            } catch (DataIntegrityViolationException e) {
                mensagem += "Deu ruim";
            }
        }
        return mensagem;
    }

}
