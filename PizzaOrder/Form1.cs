using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PizzaOrder
{
    public partial class Form1 : Form
    {
        List<String> PizzaSize = new List<String>();//creating the list
        List<String> Items = new List<String>();//creating the list
        string Size;//a string to store the size of the pizza to check later.
        double Price = 0;//the running total.
        int ToppingCount = 0;//a variable to count the number of toppings.
        bool Spec = false; //defining variables 
        bool Spec2 = false;//the spec and spec2 are used to identify if its a special offer.
        int PizzaCount = 0;//variable to store the current total of pizzas when running the special 2 offer.
        string ID;//variable to store the order infomation such as customer name and address.
        string Address;
        string CustomerName;
        string PhoneNumber;

        public Form1()
        {
            InitializeComponent();
            PizzaSize.Add("Small +£3.50"); //adding options to list so that the size can be identifed later.
            PizzaSize.Add("Medium +£5");
            PizzaSize.Add("Large +£7");

            LsbSize.Items.Add("Small +£3.50"); //adding options to the list box
            LsbSize.Items.Add("Medium +£5");
            LsbSize.Items.Add("Large +£7");

            TBControl.TabPages.Remove(TCDrinks); //removing all the tabs from the tab control
            TBControl.TabPages.Remove(TCSides);
            TBControl.TabPages.Remove(TCToppings);
            TBControl.TabPages.Remove(TCSize);
            TBControl.TabPages.Remove(TCInfo);
            TBControl.TabPages.Remove(TCOffer);


        }

        private void LsbSize_SelectedIndexChanged(object sender, EventArgs e) //size of the pizza
        {
            Size = PizzaSize[LsbSize.SelectedIndex].ToString();//assigning the size from an array based on the list box result as the index.
            MessageBox.Show(Size);//outputing the size selected.
            if (Size.Equals("Small +£3.50"))//checking if the size is large
            {
                Price = Price + 3.50; //adding the price for the small pizza.
            }
            else if(Size.Equals("Medium +£5"))//checking if the size is medium
            {
                Price = Price + 5;//adding the medium price to the total.
            }
            else
            {
                Price = Price + 7;//adding the large price to the total.
            }
            LsbMain.Items.Add(Size); //adding the size of the pizza to the list
            LblTotal.Text = ("£" + Price).ToString(); //showing total cost
            TBControl.TabPages.Remove(TCSize); //moving from size to toppings tabs by removing the current tab. 
            TBControl.TabPages.Add(TCToppings);//adding the tab that will be displayed.
        }


        private void CBAnchovies_CheckedChanged(object sender, EventArgs e)
        {
            if (CBAnchovies.Checked)//ensuring the topping isnt added to the list and price twice. This is done by checking if the check box is checked insted of just being changed.
            {
                if ((Spec == true | Spec2 == true) & ToppingCount < 4)//checking if the offer is a special offer and if the amount of toppings is smaller than 4. If it would exceed 4 dont add a topping.
                {
                    LsbMain.Items.Add("Anchovies");//adding to count and adding to list
                    ToppingCount++;//add to the counter of the number of toppings.
                }
                else//if its not a special so its not limited to 4 toppings.
                {
                    Price = Price + 0.80;//adding to the price of the total
                    LblTotal.Text = ("£" + Price).ToString();//updating price displayed on the application
                    LsbMain.Items.Add("Anchovies + 80p"); //updating list with a topping.
                }
            }
        }

        private void CBBlackOlives_CheckedChanged(object sender, EventArgs e)
        {
            if (CBBlackOlives.Checked)
            {
                if ((Spec == true | Spec2 == true) & ToppingCount < 4)
                {
                    LsbMain.Items.Add("Black Olives");//adding to count and adding to list
                    ToppingCount++;
                }
                else
                {
                    Price = Price + 0.80;
                    LblTotal.Text = ("£" + Price).ToString();//updating price and list
                    LsbMain.Items.Add("Black Olives +80p");
                }
            }
        }

        private void CBPeppers_CheckedChanged(object sender, EventArgs e)
        {
            if (CBPeppers.Checked)
            {
                if ((Spec == true | Spec2 == true) & ToppingCount < 4)
                {
                    LsbMain.Items.Add("Peppers");//adding to count and adding to list
                    ToppingCount++;
                }
                else
                {
                    Price = Price + 0.80;
                    LblTotal.Text = ("£" + Price).ToString();//updating price and list
                    LsbMain.Items.Add("Peppers +80p");
                }
            }
        }

        private void CBJalapenos_CheckedChanged(object sender, EventArgs e)
        {
            if (CBJalapenos.Checked)
            {
                if ((Spec == true | Spec2 == true) & ToppingCount < 4)
                {
                    LsbMain.Items.Add("Jalapenos");//adding to list
                    ToppingCount++;//adding to count
                }
                else
                {
                    Price = Price + 0.80;
                    LblTotal.Text = ("£" + Price).ToString();//updating price and list
                    LsbMain.Items.Add("Jalapenos +80p");
                }
            }
        }

        private void CBMushroom_CheckedChanged(object sender, EventArgs e)
        {
            if (CBMushroom.Checked)
            {
                if ((Spec == true | Spec2 == true) & ToppingCount < 4)
                {
                    LsbMain.Items.Add("Mushroom");//adding to list
                    ToppingCount++;//adding to count
                }
                else
                {
                    Price = Price + 0.80;
                    LblTotal.Text = ("£" + Price).ToString();//updating price and list
                    LsbMain.Items.Add("Mushroom +80p");
                }
            }
        }

        private void CBRedOnion_CheckedChanged(object sender, EventArgs e)
        {
            if (CBRedOnion.Checked)
            {
                if ((Spec == true | Spec2 == true) & ToppingCount < 4)
                {
                    LsbMain.Items.Add("Red Onion");//adding to list
                    ToppingCount++;//adding to count
                }
                else
                {
                    Price = Price + 0.80;
                    LblTotal.Text = ("£" + Price).ToString();//updating price and list
                    LsbMain.Items.Add("Red Onion +80p");
                }
            }
        }

        private void CBSweetcorn_CheckedChanged(object sender, EventArgs e)
        {
            if (CBSweetcorn.Checked)
            {
                if ((Spec == true | Spec2 == true) & ToppingCount < 4)
                {
                    LsbMain.Items.Add("Sweetcorn");//adding to list
                    ToppingCount++;//adding to count
                }
                else
                {
                    Price = Price + 0.80;
                    LblTotal.Text = ("£" + Price).ToString();//updating price and list
                    LsbMain.Items.Add("Sweetcorn +80p");
                }
            }
        }

        private void CBPepperoni_CheckedChanged(object sender, EventArgs e)
        {
            if (CBPepperoni.Checked)
            {
                if ((Spec == true | Spec2 == true) & ToppingCount < 4)
                {
                    LsbMain.Items.Add("Pepperoni");//adding to list
                    ToppingCount++;//adding to list
                }
                else
                {
                    Price = Price + 0.80;
                    LblTotal.Text = ("£" + Price).ToString();//updating price and list
                    LsbMain.Items.Add("Pepperoni +80p");
                }
            }
        }

        private void CBPineapple_CheckedChanged(object sender, EventArgs e)
        {
            if (CBPineapple.Checked)
            {
                if ((Spec == true | Spec2 == true) & ToppingCount < 4)
                {
                    LsbMain.Items.Add("Pineapple");//adding to list
                    ToppingCount++;//adding to count
                }
                else
                {
                    Price = Price + 0.80;
                    LblTotal.Text = ("£" + Price).ToString();//updating price and list
                    LsbMain.Items.Add("Pineapple +80p");
                }
            }
        }

        private void CBSpicyBeef_CheckedChanged(object sender, EventArgs e)
        {
            if (CBSpicyBeef.Checked)
            {
                if ((Spec == true | Spec2 == true) & ToppingCount < 4)
                {
                    LsbMain.Items.Add("Spicy Beef");//adding to list
                    ToppingCount++;//adding to count
                }
                else
                {
                    Price = Price + 0.80;
                    LblTotal.Text = ("£" + Price).ToString();//updating price and list
                    LsbMain.Items.Add("Spicy Beef +80p");
                }
            }
        }

        private void CBChicken_CheckedChanged(object sender, EventArgs e)
        {
            if (CBChicken.Checked)
            {
                if ((Spec == true | Spec2 == true) & ToppingCount < 4)
                {
                    LsbMain.Items.Add("Chicken");//adding to list
                    ToppingCount++;//adding to count
                }
                else
                {
                    Price = Price + 0.80;
                    LblTotal.Text = ("£" + Price).ToString();//updating price and list
                    LsbMain.Items.Add("Chicken +80p");
                }
            }
        }

        private void CBSausage_CheckedChanged(object sender, EventArgs e)//sausage
        {
            if (CBSausage.Checked)
            {
                if ((Spec == true | Spec2 == true) & ToppingCount < 4)
                {
                    LsbMain.Items.Add("Sausage");// adding to the list
                     ToppingCount++;//adding to count
                }
                else
                {
                    Price = Price + 0.80;
                    LblTotal.Text = ("£" + Price).ToString();//updating price and list
                    LsbMain.Items.Add("Sausage +80p");
                }
            }
        }

        private void CBHam_CheckedChanged(object sender, EventArgs e) //ham topping
        {
            if (CBHam.Checked)
            {
                if ((Spec == true | Spec2 == true) & ToppingCount < 4)
                {
                    LsbMain.Items.Add("Ham");//adding to the list
                    ToppingCount++;//adding to the topping count
                }
                else
                {
                Price = Price + 0.80;
                LblTotal.Text = ("£" + Price).ToString();//updating price and list
                    LsbMain.Items.Add("Ham +80p");
                }
            }
        }

        private void CBTuna_CheckedChanged(object sender, EventArgs e)
        {
            if (CBTuna.Checked)
            {
                if ((Spec == true | Spec2 == true) & ToppingCount < 4)//if its is a special offer 1 or 2 and 4 or less toppings
                {
                    LsbMain.Items.Add("Tuna");//adding to the list
                    ToppingCount++;//adding to the topping count
                }
                else
                {
                    Price = Price + 0.80;
                    LblTotal.Text = ("£" + Price).ToString();//updating price and list
                    LsbMain.Items.Add("Tuna +80p");
                }
            }
        }

        private void BtnNext_Click(object sender, EventArgs e)
        {
                if (ToppingCount <= 4 & Spec == true)//checking topping count and if its a special
                {
                    TBControl.TabPages.Remove(TCToppings); //moving from toppings to sides by removing the toppings page and adding the sides page
                    TBControl.TabPages.Add(TCDrinks);
                    CBAnchovies.Checked = false;//unchecking boxes
                    CBBlackOlives.Checked = false;
                    CBChicken.Checked = false;
                    CBHam.Checked = false;
                    CBJalapenos.Checked = false;
                    CBMushroom.Checked = false;
                    CBPepperoni.Checked = false;
                    CBPeppers.Checked = false;
                    CBPineapple.Checked = false;
                    CBRedOnion.Checked = false;
                    CBSausage.Checked = false;
                    CBSpicyBeef.Checked = false;
                    CBSweetcorn.Checked = false;
                    CBTuna.Checked = false;
                    LblTotal.Text = ("£" + Price).ToString();//updating the price
                    

                }
                else if (Spec2 == true & ToppingCount <= 4)//checking if there are 4 or less toppings
                { 
                    if (PizzaCount < 1)
                    {
                        LsbMain.Items.Add("Large");  //adding large pizza to the list
                    }
                    ToppingCount = 0;//reseting topping count
                    CBAnchovies.Checked = false;//unchecking boxes
                    CBBlackOlives.Checked = false;
                    CBChicken.Checked = false;
                    CBHam.Checked = false;
                    CBJalapenos.Checked = false;
                    CBMushroom.Checked = false;
                    CBPepperoni.Checked = false;
                    CBPeppers.Checked = false;
                    CBPineapple.Checked = false;
                    CBRedOnion.Checked = false;
                    CBSausage.Checked = false;
                    CBSpicyBeef.Checked = false;
                    CBSweetcorn.Checked = false;
                    CBTuna.Checked = false;
                    PizzaCount++;//adding to pizza count
                    if (PizzaCount == 2)//if there are 2 pizzas
                    {
                        TBControl.TabPages.Remove(TCToppings);//changing page
                        TBControl.TabPages.Add(TCOffer);
                        PizzaCount = 0;//setting pizza count to 0 so that every 2 pizzas in the special 2 the counter will be reset
                        Price = Price + 16.99;//adding to the running total
                        LblTotal.Text = ("£" + Price).ToString();//updateing price so that it is displayed on the app
                        
                    }
                   

                }
                else if (Spec == false & Spec2 == false)//for non special toppings. checking if a special offer has not been selected and proceeding with a standard order.
                {
                    TBControl.TabPages.Remove(TCToppings);//changing page
                    TBControl.TabPages.Add(TCSides);
                    LblTotal.Text = ("£" + Price).ToString();//price update
                    
                }
                else
                {
                    MessageBox.Show("ERROR");//Error message
                    
                }
            
        }

        private void BtnColeslaw_Click(object sender, EventArgs e) //Sides (Adding to total and list)
        {
            Price = Price + 0.70;//adding to the running total
            LblTotal.Text = ("£" + Price).ToString();//updating the total cost on the interface
            LsbSide.Items.Add("Coleslaw +70p");//adding the item to the list box of all items on the list.
        }

        private void BtnGarlicPlain_Click(object sender, EventArgs e)//adding info for garlic bread
        {
            Price = Price + 1.70;
            LblTotal.Text = ("£" + Price).ToString();
            LsbSide.Items.Add("Garlic Bread +£1.70");
        }

        private void BtnGarlicCheese_Click(object sender, EventArgs e)//adding info for garlic bread + cheese
        {
            Price = Price + 2.20;
            LblTotal.Text = ("£" + Price).ToString();
            LsbSide.Items.Add("Garlic Bread With Cheese +£2.20");
        }

        private void BtnFiveSpicyWings_Click(object sender, EventArgs e)//adding info for spicy wings
        {
            Price = Price + 3.50;
            LblTotal.Text = ("£" + Price).ToString();
            LsbSide.Items.Add("Spicy Chicken Wings x5 +£3.50");
        }

        private void BtnTenSpicyWings_Click(object sender, EventArgs e)//adding info for chicken wings
        {
            Price = Price + 6;
            LblTotal.Text = ("£" + Price).ToString();
            LsbSide.Items.Add("Spicy Chicken Wings x10 +£6");
        }

        private void BtnFrenchFriesReg_Click(object sender, EventArgs e)//adding info for regular Fries
        {
            Price = Price + 1;
            LblTotal.Text = ("£" + Price).ToString();
            LsbSide.Items.Add("French Fries Regular +£1");
        }

        private void BtnFrenchFriesLarge_Click(object sender, EventArgs e)//adding info for Large Fries
        {
            Price = Price + 1.30;
            LblTotal.Text = ("£" + Price).ToString();
            LsbSide.Items.Add("French Fries Large +£1.30");
        }



        private void BtnOfferOne_Click(object sender, EventArgs e)//adding info for large pizza
        {
            Spec = true;//setting special order = true. this is later used to determine if the user has selected the special offer
            LsbMain.Items.Add("Large Special +£8.99");//adding the large special to the list
            TBControl.TabPages.Add(TCToppings);//changing page
            TBControl.TabPages.Remove(TCOffer);
            ToppingCount = 0;//reseting the topping count. which is used to limit the toppings to 4
        }



        private void BtnCoke_Click(object sender, EventArgs e)//adding info for coke
        {
            if (Spec == true)//checking if its a special offer.
            {
                LsbSide.Items.Add("Coke");//adding the drink to the list
                TBControl.TabPages.Add(TCOffer);//changeing the page
                TBControl.TabPages.Remove(TCDrinks);
                Price = Price + 8.99;//adding to the price 
                LblTotal.Text = ("£" + Price).ToString();//updating the total cost on the interface
            }
            else
            {
                LsbSide.Items.Add("Coke +70p");//adding the drink to the list
                Price = Price + 0.70;//adding to the price 
            }
        }

        private void BtnComplete_Click(object sender, EventArgs e)
        {

            MessageBox.Show(ID + "//" + Address + "//" + PhoneNumber + "//" + CustomerName + "//" + LblTotal); //outputing customer infomation
            Price = 0; //reseting price
            LblTotal.Text = Price.ToString();//updating the price on the interface

            if(LsbItems.Items.Count > 0)
            {
                using(TextWriter tw = new StreamWriter("List.txt"))
                {
                    foreach(string itemText in LsbItems.Items)
                    {
                        tw.WriteLine(itemText);
                    }
                    foreach (string itemText in LsbMain.Items)
                    {
                        tw.WriteLine(itemText);
                    }
                    foreach (string itemText in LsbSide.Items)
                    {
                        tw.WriteLine(itemText);
                    }
                    

                }

                Process.Start("list.txt");
            }
            TBControl.TabPages.Add(TCLogin);
            TBControl.TabPages.Remove(TCOffer); 

        }

        private void BtnPepsi_Click(object sender, EventArgs e)
        {
            if (Spec == true)//checking if a special offer has been selected
            {
                LsbSide.Items.Add("Pepsi");//adding the drink to the list
                TBControl.TabPages.Add(TCOffer);//changing page
                TBControl.TabPages.Remove(TCDrinks);
                Price = Price + 8.99;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();//displaying the cost
            }
            else
            {
                LsbSide.Items.Add("Pepsi +70p");//adding the drink to the list
                Price = Price + 0.70;//adding to the total
            }
        }

        private void BtnDietCoke_Click(object sender, EventArgs e)
        {
            if (Spec == true)
            {
                LsbSide.Items.Add("Diet Coke");//adding the drink to the list
                TBControl.TabPages.Add(TCOffer);//changing page
                TBControl.TabPages.Remove(TCDrinks);
                Price = Price + 8.99;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();//displaying the cost
            }
            else
            {
                LsbSide.Items.Add("Diet Coke +70p");//adding the drink to the list
                Price = Price + 0.70;//adding to the total
            }
        }

        private void BtnSevenUp_Click(object sender, EventArgs e)
        {
            if (Spec == true)//if its a special offer 1
            {
                LsbSide.Items.Add("7-UP");//adding the drink to the list
                TBControl.TabPages.Add(TCOffer);//changing page
                TBControl.TabPages.Remove(TCDrinks);
                Price = Price + 8.99;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();//displaying the cost
            }
            else
            {
                LsbSide.Items.Add("7-UP +70p");//adding the drink to the list
                Price = Price + 0.70;//adding to the total
            }
        }

        private void BtnFanta_Click(object sender, EventArgs e)
        {
            if (Spec == true)//if its a special offer 1
            {
                LsbSide.Items.Add("Fanta");//adding the drink to the list
                TBControl.TabPages.Add(TCOffer);//changing page
                TBControl.TabPages.Remove(TCDrinks);
                Price = Price + 8.99;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();//displaying the cost
            }
            else
            {
                LsbSide.Items.Add("Fanta +70p");//adding the drink to the list
                Price = Price + 0.70;//adding to the total
            }
        }

        private void BtnTango_Click(object sender, EventArgs e)
        {
            if (Spec == true)//if its a special offer 1
            {
                LsbSide.Items.Add("Tango");//adding the drink to the list
                TBControl.TabPages.Add(TCOffer);//changing page
                TBControl.TabPages.Remove(TCDrinks);
                Price = Price + 8.99; //adding to the total
                LblTotal.Text = ("£" + Price).ToString(); //displaying the cost
            }
            else
            {
                LsbSide.Items.Add("Tango +70p");//adding the drink to the list
                Price = Price + 0.70;//adding to the total
            }
        }

        private void BtnCYO_Click(object sender, EventArgs e)
        {
            Spec2 = false;//special offer 2 false
            Spec = false;//special offer false
            TBControl.TabPages.Add(TCSize);//changing page
            TBControl.TabPages.Remove(TCOffer);
        }

        private void BtnOfferTwo_Click(object sender, EventArgs e)
        {
            Spec2 = true;
            LsbMain.Items.Add("Large Special 2 +£16.99");//adding text to the list
            TBControl.TabPages.Add(TCToppings);
            TBControl.TabPages.Remove(TCOffer);//changing page
            ToppingCount = 0;//seting toppings count to 0
        }

        private void BtnNextSides_Click(object sender, EventArgs e)
        {
            TBControl.TabPages.Add(TCDrinks);
            TBControl.TabPages.Remove(TCSides);//changing page
        }

        private void BtnNextDrinks_Click(object sender, EventArgs e)
        {
            TBControl.TabPages.Add(TCOffer);
            TBControl.TabPages.Remove(TCDrinks);//changing page

            CBAnchovies.Checked = false; //unchecking boxes by seting there checked propity to false
            CBBlackOlives.Checked = false;
            CBChicken.Checked = false;
            CBHam.Checked = false;
            CBJalapenos.Checked = false;
            CBMushroom.Checked = false;
            CBPepperoni.Checked = false;
            CBPeppers.Checked = false;
            CBPineapple.Checked = false;
            CBRedOnion.Checked = false;
            CBSausage.Checked = false;
            CBSpicyBeef.Checked = false;
            CBSweetcorn.Checked = false;
            CBTuna.Checked = false;

            LblTotal.Text = ("£" + Price).ToString();//updateing the total cost on the interface
        }
        String[] Passwords = new String[] {"Password", "Password1", "Password2", "Password3", "Password4", "Password5", "Password6", "Password7", "Password8", "Password9"}; //password array which stores a variety of passwords
        String[] Username = new String[] {"Username", "Username1", "Username2", "Username3", "Username4", "Username5", "Username6", "Username7", "Username8", "Username9" }; //username array which stores a variety of usernames

        private void BtnLogin_Click(object sender, EventArgs e)
        {
            int i = 0;//creating a counter for the loop and index of the arrays
            while (i < 10)//checking the array 10 times for the username and password
            {
                if (TxtPassword.Text.Equals(Passwords[i]) & TxtUsername.Text.Equals(Username[i])) //checking the password and username
                {                   
                            TBControl.TabPages.Add(TCInfo); //changing the page by removing the old one and adding the new one
                            TBControl.TabPages.Remove(TCLogin);
                            break;           
                }
                else 
                {
                    MessageBox.Show("Wrong password or username");
                    break;
                }
                i++;//adding to the counter
            }

        }

        private void BtnSaveInfo_Click(object sender, EventArgs e)
        {
            ID = TxtStaffID.Text;//defining varibles and store data
            Address = TxtAddress.Text;
            CustomerName = TxtCustomerName.Text;
            PhoneNumber = TxtNumber.Text;

            LsbItems.Items.Add("ID:" + ID); //adding details to the list
            LsbItems.Items.Add("Name:" + CustomerName);
            LsbItems.Items.Add("Number:" + PhoneNumber);
            LsbItems.Items.Add("Address:" + Address);

            TBControl.TabPages.Add(TCOffer);//changing page
            TBControl.TabPages.Remove(TCInfo);
        }

        private void BtnHelpLogin_Click(object sender, EventArgs e)//help buttons
        {
            MessageBox.Show("Enter your Username and Password to continue");//outputing helpful infomation
        }

        private void BtnHelpInfo_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Enter your Employee ID in the box labled 'Staff ID'");//outputing helpful infomation about the infomation page
            MessageBox.Show("Enter the customers name in the box labled 'Customer's Name'");
            MessageBox.Show("Enter the customers address in the 'Address' box");
            MessageBox.Show("Enter the customers telephone number in the 'Telephone Number' box");
        }

        private void BtnHelpOffer_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Click the deal you want to add to your purchase (all options will give the opotunity to pick additional offers)");//outputing helpful infomation about the offer page
            MessageBox.Show("Click the 'Complete' button to complete the order and restart the program");
        }

        private void BtnHelpSize_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Click the Food button you want to add and order ");//outputing helpful infomation about the Size page
        }

        private void BtnHelpToppings_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Select the toppings you want to have on the pizza. (only the first four toppings will be free for the special offers)");//outputing helpful infomation about the toppings page
        }

        private void BtnHelpSides_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Click all the sides you want with your order");//outputing helpful infomation about the sides page
        }

        private void BtnHelpDrinks_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Select all the drinks you want or the drink with your special offer");//outputing helpful infomation about the drinks page
        }

        private void BtnDelInfo_Click(object sender, EventArgs e)
        {
            LsbItems.Items.RemoveAt(LsbItems.SelectedIndex); 
        }

        private void BtnDelMain_Click(object sender, EventArgs e)
        {
            if (LsbMain.Text == "Anchovies + 80p")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 0.80;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Black Olives +80p")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 0.80;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Peppers +80p")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 0.80;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Jalapenos +80p")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 0.80;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Mushroom +80p")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 0.80;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Red Onion +80p")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 0.80;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Sweetcorn +80p")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 0.80;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Pepperoni +80p")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 0.80;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Pineapple +80p")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 0.80;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Spicy Beef +80p")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 0.80;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Chicken +80p")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 0.80;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Sausage +80p")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 0.80;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Ham +80p")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 0.80;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Tuna +80p")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 0.80;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Large Special +£8.99")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 8.99;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Large Special 2 +£16.99")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 16.99;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Small +£3.50")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 3.50;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Medium +£5")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 5.00;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbMain.Text == "Large +£7")
            {

                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
                Price = Price - 7.00;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            else if (LsbMain.SelectedIndex == -1)
            {

            }
            else
            {
                LsbMain.Items.RemoveAt(LsbMain.SelectedIndex);
            }

        }

        private void BtnDelSide_Click(object sender, EventArgs e)
        {
            if (LsbSide.Text == "Coleslaw +70p")
            {

                LsbSide.Items.RemoveAt(LsbSide.SelectedIndex);
                Price = Price - 0.70;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbSide.Text == "Garlic Bread +£1.70")
            {

                LsbSide.Items.RemoveAt(LsbSide.SelectedIndex);
                Price = Price - 1.70;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbSide.Text == "Garlic Bread With Cheese +£2.20")
            {

                LsbSide.Items.RemoveAt(LsbSide.SelectedIndex);
                Price = Price - 2.20;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbSide.Text == "Spicy Chicken Wings x5 +£3.50")
            {

                LsbSide.Items.RemoveAt(LsbSide.SelectedIndex);
                Price = Price - 3.50;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbSide.Text == "French Fries Regular +£1")
            {

                LsbSide.Items.RemoveAt(LsbSide.SelectedIndex);
                Price = Price - 1.00;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbSide.Text == "French Fries Large +£1.30")
            {

                LsbSide.Items.RemoveAt(LsbSide.SelectedIndex);
                Price = Price - 1.30;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbSide.Text == "Coke +70p")
            {

                LsbSide.Items.RemoveAt(LsbSide.SelectedIndex);
                Price = Price - 0.70;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbSide.Text == "Pepsi +70p")
            {

                LsbSide.Items.RemoveAt(LsbSide.SelectedIndex);
                Price = Price - 0.70;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbSide.Text == "Diet Coke +70p")
            {

                LsbSide.Items.RemoveAt(LsbSide.SelectedIndex);
                Price = Price - 0.70;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbSide.Text == "7-UP +70p")
            {

                LsbSide.Items.RemoveAt(LsbSide.SelectedIndex);
                Price = Price - 0.70;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbSide.Text == "Fanta +70p")
            {

                LsbSide.Items.RemoveAt(LsbSide.SelectedIndex);
                Price = Price - 0.70;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            if (LsbSide.Text == "Tango +70p")
            {

                LsbSide.Items.RemoveAt(LsbSide.SelectedIndex);
                Price = Price - 0.70;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();
            }
            else if (LsbSide.SelectedIndex == -1)
            {

            }
            else
            {
                LsbSide.Items.RemoveAt(LsbSide.SelectedIndex);
            }

        }

        private void BtnAddInfo_Click(object sender, EventArgs e)
        {
            TBControl.TabPages.Add(TCInfo);
            TBControl.TabPages.Remove(TCOffer);
        }

        private void BtnAddMain_Click(object sender, EventArgs e)
        {
            TBControl.TabPages.Add(TCSize);
            TBControl.TabPages.Remove(TCOffer);
        }

        private void BtnAddSide_Click(object sender, EventArgs e)
        {
            TBControl.TabPages.Add(TCSides);
            TBControl.TabPages.Remove(TCOffer); 
        }

        private void btn_Bread_sticks_Click(object sender, EventArgs e)
        {
            Price = Price + 0.99;
            LblTotal.Text = ("£" + Price).ToString();
            LsbMain.Items.Add(" x5 Bread Sticks +99p");
        }

        private void btn_spring_rolls_Click(object sender, EventArgs e)
        {
            Price = Price + 0.99;
            LblTotal.Text = ("£" + Price).ToString();
            LsbMain.Items.Add(" x2 Spring Rolls +99p");
        }

        private void button6_Click(object sender, EventArgs e)
        {
            Price = Price + 0.99;
            LblTotal.Text = ("£" + Price).ToString();
            LsbMain.Items.Add(" Tomato Soup +99p");
        }

        private void btn_mini_sandwich_Click(object sender, EventArgs e)
        {
            Price = Price + 0.99;
            LblTotal.Text = ("£" + Price).ToString();
            LsbMain.Items.Add("x2 Mini Cheese Sandwiches  +99p");
        }

        private void btn_pasta_Click(object sender, EventArgs e)
        {
            Price = Price + 4.00;
            LblTotal.Text = ("£" + Price).ToString();
            LsbMain.Items.Add("Pasta +£4.00");
        }

        private void btn_Spaghetti_Click(object sender, EventArgs e)
        {
            Price = Price + 4.00;
            LblTotal.Text = ("£" + Price).ToString();
            LsbMain.Items.Add("Spaghetti  +£4.00");
        }

        private void btn_Enchiladas_Click(object sender, EventArgs e)
        {
            Price = Price + 5.00;
            LblTotal.Text = ("£" + Price).ToString();
            LsbMain.Items.Add("Enchiladas   +£5.00");
        }

        private void btn_Chicken_Burger_Click(object sender, EventArgs e)
        {
            Price = Price + 3.00;
            LblTotal.Text = ("£" + Price).ToString();
            LsbMain.Items.Add("Chicken Burger +£3.00");
        }

        private void btn_Quesada_Click(object sender, EventArgs e)
        {
            Price = Price + 3.00;
            LblTotal.Text = ("£" + Price).ToString();
            LsbMain.Items.Add("Quesada +£3.00");
        }

        private void btn_Chicken_Pitta_Click(object sender, EventArgs e)
        {
            Price = Price + 2.00;
            LblTotal.Text = ("£" + Price).ToString();
            LsbMain.Items.Add("Chicken Pitta +£2.00");
        }

        private void btn_Fish_Cod_Click(object sender, EventArgs e)
        {
            Price = Price + 2.00;
            LblTotal.Text = ("£" + Price).ToString();
            LsbMain.Items.Add("Fish Cod +£2.00");
        }

        private void btn_Donnor_Kebabs_Click(object sender, EventArgs e)
        {
            Price = Price + 2.50;
            LblTotal.Text = ("£" + Price).ToString();
            LsbMain.Items.Add("x2 Donnor Kebabs +£2.50");
        }

        private void btn_Orange_Juice_Click(object sender, EventArgs e)
        {
            if (Spec == true)
            {
                LsbSide.Items.Add("Orange Juice");//adding the drink to the list
                TBControl.TabPages.Add(TCOffer);//changing page
                TBControl.TabPages.Remove(TCDrinks);
                Price = Price + 8.99;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();//displaying the cost
            }
            else
            {
                LsbSide.Items.Add("Orange Juice +50p");//adding the drink to the list
                Price = Price + 0.50;//adding to the total
            }
        }

        private void btn_apple_Click(object sender, EventArgs e)
        {
            if (Spec == true)
            {
                LsbSide.Items.Add("Apple Juice");//adding the drink to the list
                TBControl.TabPages.Add(TCOffer);//changing page
                TBControl.TabPages.Remove(TCDrinks);
                Price = Price + 8.99;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();//displaying the cost
            }
            else
            {
                LsbSide.Items.Add("Apple Juice +50p");//adding the drink to the list
                Price = Price + 0.50;//adding to the total
            }
        }

        private void btn_water_Click(object sender, EventArgs e)
        {
            if (Spec == true)
            {
                LsbSide.Items.Add("Water");//adding the drink to the list
                TBControl.TabPages.Add(TCOffer);//changing page
                TBControl.TabPages.Remove(TCDrinks);
                Price = Price + 8.99;//adding to the total
                LblTotal.Text = ("£" + Price).ToString();//displaying the cost
            }
            else
            {
                LsbSide.Items.Add("Water free");//adding the drink to the list
                Price = Price + 0.00;//adding to the total
            }
        }

        private void btn_main_Click(object sender, EventArgs e)
        {
            TBControl.TabPages.Add(TCSides);
            TBControl.TabPages.Remove(TCSize);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form3 f = new Form3();
            f.Show();
            this.Hide();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Thank you for coming to Eat Out More Often");
            this.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form2 f = new Form2();
            f.Show();
            this.Hide();
        }
    }
}
