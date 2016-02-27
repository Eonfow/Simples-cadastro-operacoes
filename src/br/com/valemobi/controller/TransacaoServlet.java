package br.com.valemobi.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

import br.com.valemobi.bean.Operacao;
import br.com.valemobi.bean.TipoMercadoria;
import br.com.valemobi.bean.TipoNegocio;
import br.com.valemobi.bo.OperacoesBO;

/**
 * Servlet implementation class TransacaoServlet
 */
@WebServlet("/TransacaoServlet")
public class TransacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OperacoesBO bo = new OperacoesBO();
		JsonObject jObj = Json.parse(request.getParameterNames().nextElement()).asObject();
		Operacao op = new Operacao();
		
		op.setCodigoMerc(jObj.getInt("codigo", 0));
		op.setNomeMerc(jObj.getString("nomeMerc", null));
		op.setPrecoTotal(jObj.getDouble("precoTotal", 0.0d));
		op.setQuantidade(jObj.getInt("quant", 0));
		
		String tipoMerc = jObj.getString("tipoMercadoria", null);
		if(tipoMerc.equals(TipoMercadoria.CAMISA.toString())){
			op.setTipoMercadoria(TipoMercadoria.CAMISA);
		
		}else if(tipoMerc.equals(TipoMercadoria.CELULAR.toString())){
			op.setTipoMercadoria(TipoMercadoria.CELULAR);
		
		}else{
			op.setTipoMercadoria(null);
		}
		
		
		String tipoNeg = jObj.getString("tipoNegocio", null);
		if(tipoNeg.equals(TipoNegocio.COMPRA.toString())){
			op.setTipoNegocio(TipoNegocio.COMPRA);		
			
		}else if(tipoNeg.equals(TipoNegocio.VENDA.toString())){
			op.setTipoNegocio(TipoNegocio.VENDA);	
			
		}else{
			op.setTipoNegocio(null);
		}
			
		try {
			bo.registrarOperacao(op);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("mostrarOperacoes.html");
	}

}
