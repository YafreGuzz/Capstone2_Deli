 <div align = "center"> 
   
   # Welcome To Deli_cious Sandwich App
 </div> 
	
<p align = "center"> The primary function of the sandwich app is to be able to order items from a Menu in a store and be able to customize the orders <p>

<details>
<summary>
  
## Main App  
</summary> 

## Home Screen
<p align = "center"> <img src = "https://github.com/YafreGuzz/Capstone2_Deli/assets/97078610/5e915356-36dc-4c11-af47-3b33502a2505" <p>

## Order Screen
<p align = "center"> <img src = "https://github.com/YafreGuzz/Capstone2_Deli/assets/97078610/0d634415-c258-47eb-b510-9f48d510b3e4" <p>

## Add Sandwich
<p align = "center"> <img src = "https://github.com/YafreGuzz/Capstone2_Deli/assets/97078610/dd74ebb2-3083-4a02-b03c-3bdfc72b5c01" <p>

## Drinks Screen

<p align = "center"> <img src = "https://github.com/YafreGuzz/Capstone2_Deli/assets/97078610/fff40678-4a2a-4a13-b3a8-104e7bbcbb06" <p>
<p align = "center"> <img src = "https://github.com/YafreGuzz/Capstone2_Deli/assets/97078610/de137e96-cb31-451b-adfe-2b6880469993" <p>

## Chips Screen
<p align = "center"> <img src = "https://github.com/YafreGuzz/Capstone2_Deli/assets/97078610/f0dedaa0-cb3e-4420-9930-0140ba1b8d3c" <p

## Receipt
<p align = "center"> <img src = "https://github.com/YafreGuzz/Capstone2_Deli/assets/97078610/c3cc53b2-5c0d-4d4f-8578-875ac2e99d4d" <p>
	
</details>

``` java
if (!currentOrder.getSandwiches().isEmpty()) {
                output.append("\n          Sandwich          \n");
                output.append("=============================\n\n");
                for (Sandwich sandwich1 : currentOrder.getSandwiches()) {
                    output.append(String.format(
                            "Bread Type: %s%nSize: %d inches \nRegular Toppings:\n%s%n \nPremium Toppings:\n%s\n Total Price: $%.2f%n",
                            sandwich1.getBreadType(),
                            sandwich1.getSize(),
                            String.join("\n", sandwich1.getRToppings()),
                            String.join("\n", sandwich1.getPToppings()),
                            sandwich1.getTotalPrice()
                    ));
                    totalPrice += sandwich1.getTotalPrice();
                }
            }

            if (!currentOrder.getDrinks().isEmpty()) {
                output.append("\n           Drinks          \n");
                output.append("=============================\n\n");

                for (Drinks drink : currentOrder.getDrinks()) {
                    output.append(String.format("%s %s $%.2f\n", drink.getSize(), drink.getBrand(), drink.getPrice()));
                    totalPrice += drink.getPrice();
                }
            }



            if (!currentOrder.getChips().isEmpty()) {
                output.append("\n            Chips          \n");
                output.append("=============================\n\n");
                for (Chips chip : currentOrder.getChips()) {
                    output.append(String.format("%s $%.2f\n", chip.getName(), chip.getPrice()));
                    totalPrice += chip.getPrice();
                }
            }
```

> This is an interesting piece of code because it checks if you have the item before printing it to the receipt. 
