# Complete Examples

**About me:**
**Linkedin:** https://www.linkedin.com/in/willian-dougherty-n-barbosa/

_These examples were built on the learning process._

# JQuery

## HTML Fields with Properties Validation
```javascript
function validateActiveRegister() {
    if ($('#activeCheck').prop('checked')) {
        recordButton.disabled = false;
        playButton.disabled = false;
        downloadButton.disabled = false;
        replaceTraining.prop('disabled', false);
    } else {
        recordButton.disabled = true;
        playButton.disabled = true;
        downloadButton.disabled = true;
        replaceTraining.prop('disabled', true);
        replaceTraining.prop('checked', false);
    }
}

function validateActiveRegisterBool() {
    if ($('#activeCheck').prop('checked')) {
        return true;
    } else {
        return false;
    }
}
```

## HTTP Rest Request

### GET
```javascript
 $.ajax({
		type: 'GET',
		url: 'http://localhost:1234/api/v1/phrasesAboutCars' + numberPhrases,

		success: function(data) {
			alert("Done!");
			$('#resultPhrases').text("200");
			
			for (var i = 0; i < numberPhrases; i++) {
				var phraseGetList = data[i].phrase;
				console.log("Interação: " + i + " Frase: " + phraseGetList);
				$("#phrasesList").append("<p align='center'>" + phraseGetList + "</p>");            
			}
		},
		error: function() {
			$('#resultPhrases').text("There was an error processing your request. Please try again.");
		}
	});
```

### POST
```javascript
	$.ajax({
            type: 'POST',
            url: 'http://localhost:1234/api/v1/needsCars',
            data: JSON.stringify(ajaxObj),
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
 
            success: function(data) {
                alert("Done!");
                $('#result').text("200");
            },
            error: function() {
                $('#result').text("There was an error processing your request. Please try again.");
            }
        });
```

# HTTP Requests with access elements inside a DIV
```javascript

	var dataGlobal;
	var needCheck;
	var haveCheck;
	 
	var ListButtonId = [];
	 
	var checkNeedShareCar;
	var checkNeedRentCar;
	var checkNeedDonationCar;
	var checkNeedBuyCar;
	var checkNeedColectCar;
	 
	var checkHaveShareCar;
	var checkHaveRendCar;
	var checkHaveDonationCar;
	var checkHaveSellCar;
	var checHaveDiscardCar;
	 
	var indexNeed;
	var indexHave;
	 
	$(document).ready(function()  {
	    $("#btnPostNeed").click(function() {
	        var ajaxObj;
	        var ajaxObjCompany;
	 
	        var titleNeedCar = $('#needTitle').val();
	        var companyId = $('#companyId').val();
	 
	        if (companyId != null && companyId > 0) {
	 
	            console.log("Cia ID Preenchida com: "+ companyId);
	 
	            ajaxObjCompany = {
	                "id" : parseInt(companyId)
	            };
	 
	            ajaxObj = {
	                "company" : ajaxObjCompany,
	                "title" : titleNeedCar
	            };
	        } else {
	            console.log("Necessidade sem Company ID");
	 
	            ajaxObj = {
	                "title" : titleNeedCar
	            };
	        };
	 
	        $.ajax({
	            type: 'POST',
	            url: 'http://localhost:1234/api/v1/needsCars',
	            data: JSON.stringify(ajaxObj),
	            dataType: "json",
	            contentType: "application/json;charset=UTF-8",
	 
	            success: function(data) {
	                alert("Done!");
	                $('#result').text("200");
	            },
	            error: function() {
	                $('#result').text("There was an error processing your request. Please try again.");
	            }
	        });
	    });
	 
	    $("#btnGetPhrases").click(function() {
	        var numberPhrases = $("#numberPhrases").val();
	        
	        $.ajax({
	            type: 'GET',
	            url: 'http://localhost:1234/api/v1/phrasesAboutCars' + numberPhrases,
	 
	            success: function(data) {
	                alert("Done!");
	                $('#resultPhrases').text("200");
	                
	                for (var i = 0; i < numberPhrases; i++) {
	                    var phraseGetList = data[i].phrase;
	                    console.log("Iteraçao: " + i + " Frase: " + phraseGetList);
	                    $("#phrasesList").append("<p align='center'>" + phraseGetList + "</p>");            
	                }
	            },
	            error: function() {
	                $('#resultPhrases').text("There was an error processing your request. Please try again.");
	            }
	        });
	    });
	    
	    $("#btnGetFormItem").click(function() {
	        $.ajax({
	            type: 'GET',
	            url: 'http://localhost:8080/api/v1/formItems',
	 
	            success: function(data) {
	                dataGlobal = data;
	                $('#resultFormItem').text("200");
	                
	                console.log("GET data formItem:");
	                console.log($(dataGlobal));  
	                
	                for (d = 0;  d < dataGlobal.length; d++) {
	                    if (dataGlobal[d].parentNode == true) {
	                        var necessitoFirstLevel = dataGlobal[d].fieldLabel;
	                        indexNeed = d;
	             
	                        for (z = d;  z < dataGlobal.length; d++) {
	                            if (dataGlobal[z].parentNode == true) {
	                                var tenhoFirstLevel = dataGlobal[z].fieldLabel;
	                                indexHave = z;
	                                break;
	                            }
	                        }
	                        break;
	                    }            
	                }
	                
	                $("#firstLevel").append(
	                                                    "<center><input type='radio' name='titleNeedCar' id='PNFirstCheck'> " + necessitoFirstLevel +
	                                                    "<input type='radio' name='titleNeedCar' id='PNSecondCheck'> " + tenhoFirstLevel + "</center>");   
	            },
	            error: function() {
	                $('#resultFormItem').text("There was an error processing your request. Please try again.");
	            }
	        });
	    });
	    
	    $("#btn2Level").click(function() {
	        $("#secondLevel").empty();
	        $("#thirdLevel").empty();
	         
	        needCheck = $("#firstLevel input#PNFirstCheck");
	        haveCheck = $("#firstLevel input#PNSecondCheck");
	        
	        if (needCheck.prop('checked')) {
	            limpaListButtonIdArray();
    
	            $("#secondLevel").append("<center><h3>EU NECESSITO: </h3></center>");
	                
	            for (var i = 0; i < dataGlobal[indexNeed].listFormItem.length; i++) {              
	                 /* Criacao por RadioButton */
	                $("#secondLevel").append("<center><input type='radio' id='" + dataGlobal[indexNeed].listFormItem[i].fieldName + "' name='typeNeed'>" + dataGlobal[indexNeed].listFormItem[i].fieldLabel + "</center>");
	                ListButtonId.push(dataGlobal[indexNeed].listFormItem[i].fieldName);
	            }
	            alimentaButtonVarNecessito();
	        } else {
	            console.log("Need not selected");    
	        }
	        
	        if (haveCheck.prop('checked')) {
	            limpaListButtonIdArray();
 
	            $("#secondLevel").append("<center><h3>EU TENHO PARA: : </h3></center>");            
	                
	            for (var i = 0; i < dataGlobal[indexHave].listFormItem.length; i++) {
	                /* Criacao por RadioButton */
	                $("#secondLevel").append("<center><input type='radio' id='" + dataGlobal[indexHave].listFormItem[i].fieldName + "' name='typeNeed'>" + dataGlobal[indexHave].listFormItem[i].fieldLabel + "</center>");
	                ListButtonId.push(dataGlobal[indexHave].listFormItem[i].fieldName);
	            }
	            
	            alimentaButtonVarTenho();
	        } else {
	            console.log("Have not selected"); 
	        }
	        
	        $('#resultFormItem2').text("200");
	    });
	    
	    $("#btn3Level").click(function() {
	        $("#thirdLevel").empty(); 
	        
	        if (needCheck.prop('checked')) {
	 
	            if (checkNeedShareCar.prop('checked')) {
	                
	                $("#thirdLevel").append("<p align='center'>" +  dataGlobal[indexNeed].listFormItem[indexNeed].fieldLabel + "  Opçoes</p>");
	                
	                for (var x = 0; x < dataGlobal[indexNeed].listFormItem[indexNeed].listFormItem.length; x++) {
	                    $("#thirdLevel").append("<center><input type='radio' id='" + dataGlobal[indexNeed].listFormItem[indexNeed].listFormItem[x].fieldName + "'>" + dataGlobal[indexNeed].listFormItem[indexNeed].listFormItem[x].fieldLabel + "</center>");
	                }
	                
	                $("#thirdLevel").append("<br>");
	                $("#thirdLevel").append("<br>");
	                $("#thirdLevel").append("<br>");
	                
	            } 
	            
	            if (checkNeedRentCar.prop('checked')) {
	                
	                $("#thirdLevel").append("<p align='center'>" +  dataGlobal[indexNeed].listFormItem[1].fieldLabel + "  Opçoes</p>");
	                
	                for (var x = 0; x < dataGlobal[indexNeed].listFormItem[1].listFormItem.length; x++) {
	                    $("#thirdLevel").append("<center><input type='radio' id='" + dataGlobal[indexNeed].listFormItem[1].listFormItem[x].fieldName + "'>" + dataGlobal[indexNeed].listFormItem[1].listFormItem[x].fieldLabel + "</center>");
	                }
	                
	                $("#thirdLevel").append("<br>");
	                $("#thirdLevel").append("<br>");
	                $("#thirdLevel").append("<br>");
	                
	            }
	            
	            if (checkNeedDonationCar.prop('checked')) {
	                
	                $("#thirdLevel").append("<p align='center'>" +  dataGlobal[indexNeed].listFormItem[2].fieldLabel + "  Opçoes</p>");
	                
	                for (var x = 0; x < dataGlobal[indexNeed].listFormItem[2].listFormItem.length; x++) {
	                    $("#thirdLevel").append("<center><input type='radio' id='" + dataGlobal[indexNeed].listFormItem[2].listFormItem[x].fieldName + "'>" + dataGlobal[indexNeed].listFormItem[2].listFormItem[x].fieldLabel + "</center>");
	                }
	                
	                $("#thirdLevel").append("<br>");
	                $("#thirdLevel").append("<br>");
	                $("#thirdLevel").append("<br>");
	                
	            }
	            
	            if (checkNeedBuyCar.prop('checked')) {
	                
	                $("#thirdLevel").append("<p align='center'>" +  dataGlobal[indexNeed].listFormItem[3].fieldLabel + "  Opçoes</p>");
	                
	                for (var x = 0; x < dataGlobal[indexNeed].listFormItem[3].listFormItem.length; x++) {
	                    $("#thirdLevel").append("<center><input type='radio' id='" + dataGlobal[indexNeed].listFormItem[3].listFormItem[x].fieldName + "'>" + dataGlobal[indexNeed].listFormItem[3].listFormItem[x].fieldLabel + "</center>");
	                }
	                
	                $("#thirdLevel").append("<br>");
	                $("#thirdLevel").append("<br>");
	                $("#thirdLevel").append("<br>");
	                
	            }
	            
	            if (checkNeedColectCar.prop('checked')) {
	                
	                $("#thirdLevel").append("<p align='center'>" +  dataGlobal[indexNeed].listFormItem[4].fieldLabel + "  Opçoes</p>");
	                
	                for (var x = 0; x < dataGlobal[indexNeed].listFormItem[4].listFormItem.length; x++) {
	                    $("#thirdLevel").append("<center><input type='radio' id='" + dataGlobal[indexNeed].listFormItem[4].listFormItem[x].fieldName + "'>" + dataGlobal[indexNeed].listFormItem[4].listFormItem[x].fieldLabel + "</center>");
	                }
	                
	                $("#thirdLevel").append("<br>");
	                $("#thirdLevel").append("<br>");
	                $("#thirdLevel").append("<br>");
	                
	            }
	        } else if (haveCheck.prop('checked')) {
	            
	                if (checkHaveShareCar.prop('checked')) {
	                    
	                    $("#thirdLevel").append("<p align='center'>" +  dataGlobal[indexHave].listFormItem[0].fieldLabel + "  Opçoes</p>");
	                
	                    for (var x = 0; x < dataGlobal[indexHave].listFormItem[0].listFormItem.length; x++) {
	                        $("#thirdLevel").append("<center><input type='radio' id='" + dataGlobal[indexHave].listFormItem[0].listFormItem[x].fieldName + "'>" + dataGlobal[indexHave].listFormItem[0].listFormItem[x].fieldLabel + "</center>");
	                    }
	                    
	                    $("#thirdLevel").append("<br>");
	                    $("#thirdLevel").append("<br>");
	                    $("#thirdLevel").append("<br>");
	                    
	                }
	                
	                if (checkHaveRendCar.prop('checked')) {
	                    
	                    $("#thirdLevel").append("<p align='center'>" +  dataGlobal[indexHave].listFormItem[1].fieldLabel + "  Opçoes</p>");
	                
	                    for (var x = 0; x < dataGlobal[indexHave].listFormItem[1].listFormItem.length; x++) {
	                        $("#thirdLevel").append("<center><input type='radio' id='" + dataGlobal[indexHave].listFormItem[1].listFormItem[x].fieldName + "'>" + dataGlobal[indexHave].listFormItem[1].listFormItem[x].fieldLabel + "</center>");
	                    }
	                    
	                    $("#thirdLevel").append("<br>");
	                    $("#thirdLevel").append("<br>");
	                    $("#thirdLevel").append("<br>");
	                    
	                }
	                
	                if (checkHaveDonationCar.prop('checked')) {
	                    
	                    $("#thirdLevel").append("<p align='center'>" +  dataGlobal[indexHave].listFormItem[2].fieldLabel + "  Opçoes</p>");
	                
	                    for (var x = 0; x < dataGlobal[indexHave].listFormItem[2].listFormItem.length; x++) {
	                        $("#thirdLevel").append("<center><input type='radio' id='" + dataGlobal[indexHave].listFormItem[2].listFormItem[x].fieldName + "'>" + dataGlobal[indexHave].listFormItem[2].listFormItem[x].fieldLabel + "</center>");
	                    }
	                    
	                    $("#thirdLevel").append("<br>");
	                    $("#thirdLevel").append("<br>");
	                    $("#thirdLevel").append("<br>");
	                    
	                }
	                
	                if (checkHaveSellCar.prop('checked')) {
	                    
	                    $("#thirdLevel").append("<p align='center'>" +  dataGlobal[indexHave].listFormItem[3].fieldLabel + "  Opçoes</p>");
	                
	                    for (var x = 0; x < dataGlobal[indexHave].listFormItem[3].listFormItem.length; x++) {
	                        $("#thirdLevel").append("<center><input type='radio' id='" + dataGlobal[indexHave].listFormItem[3].listFormItem[x].fieldName + "'>" + dataGlobal[indexHave].listFormItem[3].listFormItem[x].fieldLabel + "</center>");
	                    }
	                    
	                    $("#thirdLevel").append("<br>");
	                    $("#thirdLevel").append("<br>");
	                    $("#thirdLevel").append("<br>");
	                    
	                }
	                
	                if (checHaveDiscardCar.prop('checked')) {
	                    
	                    $("#thirdLevel").append("<p align='center'>" +  dataGlobal[indexHave].listFormItem[4].fieldLabel + "  Opçoes</p>");
	                
	                    for (var x = 0; x < dataGlobal[indexHave].listFormItem[4].listFormItem.length; x++) {
	                        $("#thirdLevel").append("<center><input type='radio' id='" + dataGlobal[indexHave].listFormItem[4].listFormItem[x].fieldName + "'>" + dataGlobal[indexHave].listFormItem[4].listFormItem[x].fieldLabel + "</center>");
	                    }
	                    
	                    $("#thirdLevel").append("<br>");
	                    $("#thirdLevel").append("<br>");
	                    $("#thirdLevel").append("<br>");
	                    
	                }
	        }
	        $('#resultFormItem3').text("200");
	    });
	});
	 
	function limpaListButtonIdArray() {
	    ListButtonId = [];
	};
	 
	function alimentaButtonVarNecessito() {
	    var btn3L1 = ListButtonId[0];
	    var btn3L2 = ListButtonId[1];
	    var btn3L3 = ListButtonId[2];
	    var btn3L4 = ListButtonId[3];
	    var btn3L5 = ListButtonId[4];
	    
	    checkNeedShareCar = $("#secondLevel input#" + btn3L1);
	    checkNeedRentCar = $("#secondLevel input#" + btn3L2);
	    checkNeedDonationCar = $("#secondLevel input#" + btn3L3);
	    checkNeedBuyCar = $("#secondLevel input#" + btn3L4);
	    checkNeedColectCar = $("#secondLevel input#" + btn3L5);
	};
	 
	function alimentaButtonVarTenho() {
	    var btn3L6 = ListButtonId[0];
	    var btn3L7 = ListButtonId[1];
	    var btn3L8 = ListButtonId[2];
	    var btn3L9 = ListButtonId[3];
	    var btn3L10 = ListButtonId[4];
	    
	    checkHaveShareCar = $("#secondLevel input#" + btn3L6);
	    checkHaveRendCar = $("#secondLevel input#" + btn3L7);
	    checkHaveDonationCar = $("#secondLevel input#" + btn3L8);
	    checkHaveSellCar = $("#secondLevel input#" + btn3L9);
	    checHaveDiscardCar = $("#secondLevel input#" + btn3L10);
	};
```