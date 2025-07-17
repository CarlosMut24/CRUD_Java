package relatorio;

import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import model.UsuarioModel;

public class UsuarioDataSource implements JRDataSource {

    private Iterator iterator;
    private Object valorAtual;

    private int i = 0;

    private boolean irParaProximoAluno = true;

    /**
     * @param campos
     * @param itr
     */
    public UsuarioDataSource(List lista) {
        super();
        this.iterator = lista.iterator();
    }

    public boolean next() throws JRException {
        valorAtual = iterator.hasNext() ? iterator.next() : null;
        irParaProximoAluno = (valorAtual != null);
        return irParaProximoAluno;
    }

    public Object getFieldValue(JRField campo) throws JRException {
        Object valor = null;
        UsuarioModel objModel = (UsuarioModel) valorAtual;

        if ("USU_CODIGO".equals(campo.getName())) {
            valor = objModel.getUSU_CODIGO();
        } else if ("USU_NOME".equals(campo.getName())) {
            valor = objModel.getUSU_NOME();
        } else if ("USU_LOGIN".equals(campo.getName())) {
            valor = objModel.getUSU_LOGIN();
        }

        return valor;
    }
}