$(document).ready(function () {

    //clearfield = new ClearfieldsController();
    //tags = new TagsView();
    console.log("entrou");
    /* formularios de todos os cadastros */
  
    /*if($("#form-editora").length){// Aqui vc pode colocar uma funcao que vai receber um formulario que vai esconder as divs
    	esconderDiv(document.getElementById("form-editora"), 0, document.getElementById("form-editora").length);
    }*/
 // Senão vc pode criar uma div sem colocar a class, mas lembre de colocar o id

    /* Esconder as divs de cadastro */

    /* disabilitar os campos */
    $("#cep-padrao").val("");
    $("#cidade").attr("disabled", true);
    $("#estado").attr("disabled", true);
    if($("#bairro").length){
    	if($("#bairro").val().length > 0){
            $("#bairro").attr("disabled", true);
        }
    }
});

$("#cep-padrao").keyup(function (event) {
    let val = new ValidacaoController;
    let tags = new TagsView;
    if(val.validacaoFieldLength(8, this)){
    	if($("#cadastro-editora").length){// Para cada formulario vc verifica se ele existe no documento do html, lembre de verificar,
    		//senao pode dar erro no script e não funcionar 
	        $("#cadastro-editora").attr("disabled", true);
            document.getElementById("preencha-div").innerHTML = "";
            let div = tags.criarTag(document.getElementById("preencha-div"), "div");// aqui vc passar um div lá do formulario
            div.setAttribute("class", "alert alert-danger"); // e aqui ele cria a class
            let span = tags.criarTag(div, "span"); // cria o texto da div
            span.textContent = "Preencha o campo obrigatório!";
    	}    
    }else{
        if($("#cadastro-editora").length){
            $("#cadastro-editora").attr("disabled", false);
            document.getElementById("preencha-div").innerHTML = "";
        }
    }
});
// Essa função é uma função anonima do JS e é um evento quando digitar qualquer tecla do teclado ele chama essa funcao
$("#cep-padrao").keyup(function (event){// nessa função faz a requisição para consultar o cep pela API
    let mascara = new MascaraController(this);// Aqui tb têm que criar o script para instanciar o objeto
    mascara.mascaraCEP(event);
    if(mascara.keyCodeBackspaceAndDelete(event)){
        $("#cidade").val("");
        $("#estado").val("");
        $("#bairro").attr("disabled", false);
        if($("#bairro").val() != ""){
            $("#bairro").val("");
        }
        entrou = false;
        $("#cep-padrao-div").hide("slow");
    }else {
        if(mascara.keyCodeNumber(event)){
            if(event.length === undefined){
                if(($("#cep-padrao").val().length == tamanhoCep) && (entrou == false)){// Se o tamanho do cep é o padrão ele faz a requisicao
                    let api = new Api();// Se vc vai ter aqui colocar o script que vai ter esse objeto, senão vai dar erro
                    entrou = true;
                    let formEditora = document.getElementById("form-editora");     
                    if($("#form-editora").length){
                    	api.apiCep($(this).val(), formEditora);
                    }
                }
            }
        }else{
            entrou = false;
            $("#cep-padrao").val("");
            $("#estado").val("");
            $("#cidade").val("");
        }
    }
});

$("#cadastro-editora").click(function(event) {
	let required = new RequiredController(this);
    let form = document.getElementById("form-editora");
    let inputs = document.getElementsByTagName("input");
    let val = new ValidacaoController;
    if(($("#cidade").val() != "") && ($("#estado").val() != "")
        && ($("#bairro").val() != "")
        && ($("#crm").val() != "")
        && (!val.validacaoFieldLength(13, document.getElementById("cpf")))
        && (exe == extensao)) {
        $("#cidade").attr("disabled", false);
        $("#bairro").attr("disabled", false);
        $("#estado").attr("disabled", false);
        $("#cadastro-editora").submit();
    } else{
        event.preventDefault();
        for(let j = 1; j < form.length-1;j++){
            for(let i = 1; i < inputs.length;i++){
                if(form[j].id != "cidade" && form[j].id != "estado"){
                    if((inputs[i].id == form[j].id)){
                        if(required.requiredInput(inputs[i].id)){
                            clearfield.clear(form[j].id+"-div");
                            let div = tags.criarTag(document.getElementById(form[j].id+"-div"), "div");
                            div.setAttribute("class", "alert alert-danger");
                            let span = tags.criarTag(div, "span");
                            span.textContent = "campo obrigatório!";
                        }
                    }
                }
            }
        }

        if(exe != extensao){
            clearfield.clear("file-div");
            let div = tags.criarTag(document.getElementById("file-div"), "div");
            div.setAttribute("class", "alert alert-danger");
            let span = tags.criarTag(div, "span");
            span.textContent = "campo obrigatório!";
        }
        if(val.validacaoFieldLength(13, document.getElementById("cpf"))){
            clearfield.clear("cpf-div");
            let div = tags.criarTag(document.getElementById("cpf-div"), "div");
            div.setAttribute("class", "alert alert-danger");
            let span = tags.criarTag(div, "span");
            span.textContent = "Preencha campo!";
        }
        if(val.validacaoFieldLength(14, document.getElementById("phone"))){
            clearfield.clear("phone-div");
            let div = tags.criarTag(document.getElementById("phone-div"), "div");
            div.setAttribute("class", "alert alert-danger");
            let span = tags.criarTag(div, "span");
            span.textContent = "Preencha campo!";
        }
    }
});
