$("#enviar").click(cadastrarUsuario);

  function cadastrarUsuario(){
  	let nome = $("#nome").val();
  	let matricula = $("#matricula").val();
  	let email = $("#email").val();
  	let cargo = $("#cargo").val();

  	$.ajax({
  		type: "POST",
  		url: "/cadastro",
  		data:{
  			nome:nome,
  			matricula:matricula,
  			email:email,
  			cargo:cargo,
  		},
  		success:function(data){
  			alert("OK");
  		},
  		error:function(){
  			alert("Não OK");
  		}
  	});
  }