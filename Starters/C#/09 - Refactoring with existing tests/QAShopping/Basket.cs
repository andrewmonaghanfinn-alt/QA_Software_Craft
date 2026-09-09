using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QAShopping
{
    public static class Basket
    {

        private const double VAT = 0.20;

        public static string PrintBasket(dynamic itemBasket)
        {
            string printOutput = "Item Name\t\t\tPrice\n";
            double total = 0.00;

            foreach (dynamic item in itemBasket)
            {
                printOutput += FormatItem(item);
                total += CalculatePrice(item);
            }

            printOutput += $"\n\t\t\tTotal\t£{total:0.00}";

            return printOutput;
        }

        private static string FormatItem(dynamic item)
        {
            string itemString = "";

            string name = getItemName(item);
            double price = getItemPrice(item);
            bool vat = getItemVat(item);

            itemString += name.Length < 16 ? name + "\t\t\t" : name + "\t\t";
            double itemPrice = CalculatePrice(item);
            itemString += $"{itemPrice:0.00}\n";

            return itemString;
        }

        private static string getItemName(dynamic item)
        {
            return item.GetType().GetProperty("_name").GetValue(item).ToString();
        }

        private static double getItemPrice(dynamic item)
        {
            return (double)item.GetType().GetProperty("_price").GetValue(item);
        }

        private static bool getItemVat(dynamic item)
        {
            return (bool)item.GetType().GetProperty("_vat").GetValue(item);
        }

        private static double CalculatePrice(dynamic item)
        {
            double price = getItemPrice(item);
            bool vat = getItemVat(item);

            return vat ? Math.Round(price + price * VAT, 2) : price;
        }


    }


}
