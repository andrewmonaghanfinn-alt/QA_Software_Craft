using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QAShopping
{
    public class Item
    {
        private int id;
        private string name;
        private double price;
        private Boolean hasVat;
        private const double VAT = 0.20;

        Item(int id, string name, double price, Boolean hasVat)
        {
            this.id = id;
            this.name = name;
            this.price = price;
            this.hasVat = hasVat;
        }

        public string getItemName()
        {
            return name;
        }

        public double getItemPrice()
        {
            if (hasVat)
            {
                return Math.Round(price * (1 + VAT), 2);
            }
         
            return price;
        }

        public Boolean itemHasVat()
        {
            return hasVat;
        }

        public string getItemString()
        {
            string itemString = "";

            itemString += getItemName().Length < 16 ? getItemName() + "\t\t\t" : getItemName() + "\t\t";
            double itemPrice = getItemPrice();
            itemString += $"{itemPrice:0.00}\n";

            return itemString;
        }

    }
}
