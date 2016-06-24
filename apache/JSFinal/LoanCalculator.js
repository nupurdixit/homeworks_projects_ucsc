/**
 * Created by nupur on 6/22/2016.
 */
function calculate() {
    
        
        var loanAmount = document.getElementById("LA").value;
        var AnnualInterest = document.getElementById("AI").value;
        var rePayYears = document.getElementById("RPY").value;
        var zipcode=document.getElementById("zip").value;
        console.log("loan amount is:"+loanAmount)
        console.log("flag is:"+flag)
            
            if(loanAmount==''){
                flag=false;
                document.getElementById("errors1").innerHTML="Please enter a valid loan amount"
                
            }
            else{
                flag=true
            }
            
            if(AnnualInterest==''){
                document.getElementById("errors2").innerHTML="Please enter a valid Annual Interest"
                flag=false
            }
            else{
                flag=true
            }

            if(rePayYears==''){
                document.getElementById("errors3").innerHTML="Please enter valid Years"
                flag=false
            }
            else{
                flag=true
            }
        

        if(flag==true){
            document.getElementById("errors1").innerHTML=""
            document.getElementById("errors2").innerHTML=""
            document.getElementById("errors3").innerHTML=""
            var rePayYearsInMonths = rePayYears * 12;
            var AnnIntPerMonth = AnnualInterest / 1200;

            
            var monthlyPayment = loanAmount * AnnIntPerMonth / (1 - (Math.pow(1 / (1 + AnnIntPerMonth), rePayYearsInMonths)));
            output1 = '$' + monthlyPayment
            document.getElementById('output1').innerHTML = output1;

            var totalPayment = ((AnnIntPerMonth * loanAmount) / (1 - Math.pow((1 + AnnIntPerMonth), (-1 * rePayYearsInMonths)))) * rePayYearsInMonths
            output2 = '$' + totalPayment
            document.getElementById('output2').innerHTML = output2;

            var totalInterest = (rePayYearsInMonths * AnnIntPerMonth) - loanAmount;
            output3 = '$' + totalInterest
            document.getElementById('output3').innerHTML = output3;

            console.log("zipcode is"+zipcode)
            if(zipcode!=''){

                getLenders(loanAmount,AnnualInterest,rePayYears,zipcode)
            }
        }
    

}



    
/******AJAX CALL**********************/
function getRequest(){
    var request=new XMLHttpRequest();
    return request;
}

function getLenders(loanAmount,AnnualInterest,rePayYears,zipcode){
    var req=getRequest();
    var output=''
    req.onreadystatechange=function() {
        if (req.readyState == 4 && req.status == 200) {
            var items = JSON.parse(req.responseText)
            console.log(req.responseText);
            console.log(items);
            for (var item in items) {
                output +=items[item]
            }
        }

            document.getElementById('sponsors').innerHTML=output
        }

    req.open('GET','http://localhost/JSFinal/loan.php/',true);
    req.send();
}
    