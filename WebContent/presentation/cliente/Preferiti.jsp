<%
	if (request.getSession().getAttribute("utente") != null) {
		Utente utenteC = (Utente) request.getSession().getAttribute("utente");
		if (!utenteC.getTipo().equalsIgnoreCase("cliente")) {
			if (utenteC.getTipo().equalsIgnoreCase("amministratore")) {
				response.sendRedirect("../amministratore/AmministratoreCatalogo.jsp");
			} else {
				response.sendRedirect("../amministratoreOrdini/AmministratoreOrdiniOrdine.jsp");
			}
		}}
%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="java.util.*,bean.*,control.gestioneInterazioneLibro.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styleCliente2.css">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>I miei preferiti</title>
</head>
<body>

	<%@ include file="header.jsp"%>
	<%
		Collection<?> preferiti = (Collection<?>) request.getSession().getAttribute("preferiti");
	%>
	<h1 class="title-preferiti">I miei preferiti</h1>

	<%
		if (preferiti != null && preferiti.size() > 0) {

			Iterator it = preferiti.iterator();
			while (it.hasNext()) {

				Libro bean = (Libro) it.next();
	%>

	<div class="container-preferiti">
		<div class="preferiti-immagine">
			<img src="../image/<%=bean.getFoto()%>">
		</div>

		<div class="container-preferiti2">
			<div class="intestazione-preferiti">
				<h2><%=bean.getTitolo() + " "%></h2>
				<h6>
					<%
							int i = 0;
									for (i = 0; i < bean.getAutori().size(); i++) {
										String temp = bean.getAutori().get(i).getNome();

										if (i == bean.getAutori().size() - 1) {
						%>
					<%=temp%>
					<%
							} else {
						%>
					<%=temp + ", "%>
					<%
							}
									}
						%>
				</h6>
				<h4><%=bean.getPrezzo()%></h4>


			</div>

			<div class="descrizione-preferiti">
				<%=bean.getTrama()%>
			</div>
			<div class="bottone-preferiti">
				<form action="rimuoviLibroPreferiti">
					<input type="hidden" value=<%=bean.getIsbn()%> name="isbn">
					<button class="btn btn-danger">Rimuovi</button>
				</form>
			</div>
		</div>
	</div>
	<%
		}
		}
	%>


	<%@ include file="footer.jsp"%>

</body>
</html>