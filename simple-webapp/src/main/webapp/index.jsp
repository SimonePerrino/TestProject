<html> 
<body>
<head>
<style>
h1, form, p, h2 {
  color: blue;
  text-align: left;
} 
</style>
</head>
<h2>Hello World!</h2>
<p>Questa � una prova!!!</p>
<h1>Let's create a new user</h1>
	<form method = "post" action = "CreateUser.do">
		nome: <input type = "text" maxlength="40" name="nome"/> <br/>
		cognome: <input type = "text" maxlength="40" name="cognome"/> <br/>
		et�: <input type = "number" maxlength = "2" name="et�"/> <br/>
		citt� di residenza: <input type = "text" maxlength="20" name = "citt� di residenza"/> <br/> 
		indirizzo: <input type = "text" maxlength = "30" name = "indirizzo"/> <br/>
		numero di telefono: <input type = "text" maxlength = "20" name = "numero di telefono"/> <br/>	
		<input type = "submit" value = "create">
	</form>
</body>
</html>
