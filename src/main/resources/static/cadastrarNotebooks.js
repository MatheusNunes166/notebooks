$("#enviar").click(cadastrarNotebook);

function cadastrarNotebook(){
  	let numero = $("#numero").val();
  	let patrimonio = $("#patrimonio").val();

  	$.ajax({
  	type: "POST",
  	url: "/cadastro/Notebook",
  	data:{
  	numero:numero,
  	patrimonio:patrimonio,
  	},
  	success :function(data){
             			alert(data);
             		},
             		error:function(){
             			alert("Não OK");
             		}
  	});
  	}