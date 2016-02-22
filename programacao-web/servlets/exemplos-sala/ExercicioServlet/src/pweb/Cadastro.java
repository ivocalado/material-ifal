package pweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Pessoa> pessoas = new ArrayList<>();

	/**
	 * Default constructor.
	 */
	public Cadastro() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param cria
	 *            uma tag inicial sem atributos
	 * @return
	 */
	private String createBeginTag(String tag) {
		return createBeginTag(tag, "");
	}

	/**
	 * 
	 * @param cria
	 *            uma tag com atributos
	 * @return
	 */
	private String createBeginTag(String tag, String atributos) {
		return "<" + tag + ((atributos.equals("")) ? "" : " " + atributos)
				+ ">";
	}

	/**
	 * 
	 * @param tag
	 * @return
	 */
	private String createEndTag(String tag) {
		return "</" + tag + ">";
	}

	private String buildTable() {
		String str = "<table border='1'>\n";
		str += createBeginTag("tr") + createBeginTag("th") + "Nome"
				+ createEndTag("th") + createBeginTag("th") + "Endereço"
				+ createEndTag("th") + createBeginTag("th") + "CPF"
				+ createEndTag("th") + createEndTag("tr") + "\n";

		for (Pessoa p : pessoas) {
			str += createBeginTag("tr") + createBeginTag("td") + p.getNome()
					+ createEndTag("td") + createBeginTag("td")
					+ p.getEndereco() + createEndTag("td")
					+ createBeginTag("td") + p.getCpf() + createEndTag("td")
					+ createEndTag("tr") + "\n";
		}

		str += "</table>";
		return str;

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String str = createBeginTag("html")
				+ "\n"
				+ createBeginTag("head")
				+ createBeginTag("meta",
						"http-equiv='content-type' content='text/html; charset='utf8'")
				+ "\n" + createEndTag("head") + "\n" + createBeginTag("body")
				+ "\n";
		str += createBeginTag("form", "action='cadastro' method='post'") + "\n";
		str += "Nome: " + createBeginTag("input", "name='nome' type='text'")
				+ createBeginTag("br") + "\n";
		str += "Endereço: " + createBeginTag("input", "name='end' type='text'")
				+ createBeginTag("br") + "\n";
		str += "CPF: " + createBeginTag("input", "name='cpf' type='text'")
				+ createBeginTag("br") + "\n";
		str += createBeginTag("input", "value='Cadastrar' type='submit'")
				+ createBeginTag("br") + "\n";
		str += createEndTag("form");
		str += createBeginTag("br") + "\n";
		str += createBeginTag("br") + "\n";
		str += createBeginTag("br") + "\n";
		str += buildTable();
		str += createEndTag("body") + "\n";
		str += createEndTag("html") + "\n";

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		// ServletOutputStream out = response.getOutputStream(); //Outra forma
		// de obter o stream de saida

		out.println(str);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String end = request.getParameter("end");
		String cpf = request.getParameter("cpf");
		Pessoa p = new Pessoa();
		p.setNome(nome);
		p.setEndereco(end);
		p.setCpf(cpf);
		pessoas.add(p);
		doGet(request, response);
	}

}
