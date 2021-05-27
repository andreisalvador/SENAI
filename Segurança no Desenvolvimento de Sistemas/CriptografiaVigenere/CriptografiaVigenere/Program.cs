using System;
using System.Linq;
using System.Text;

namespace CriptografiaVigenere
{
    class Program
    {
        static byte ALPHABET_LENGTH = 26;
        static byte START_LETTER = (byte)'A';
        static byte FINISH_LETTER = (byte)'Z';
        static byte LINE_KEY_INDEX = 0;
        static string KEY = "FOMEEEEEEEEEEEE";
        static void Main(string[] args)
        {
            char[,] table = CreateTable();

            string message = "OI";

            string key = GetKey(message.Length);

            string encryptedMessage = Encrypt(table, message, key);            
            
            Console.WriteLine($"Encrypted: {encryptedMessage}");

            string decryptedMessage = Decrypt(table, encryptedMessage, key);

            Console.WriteLine($"Decrypted: {decryptedMessage}");
        }

        public static string Decrypt(char[,] table, string encryptedMessage, string key)
        {
            StringBuilder decryptedMessage = new StringBuilder();

            for (int index = 0; index < encryptedMessage.Length; index++)
                decryptedMessage.Append(FindDecryptedLetter(table, encryptedMessage[index], key[index]));

            return decryptedMessage.ToString();
        }

        public static string Encrypt(char[,] table, string message, string key)
        {
            StringBuilder encryptedMessage = new StringBuilder();

            for (int index = 0; index < message.Length; index++)
                encryptedMessage.Append(FindEncryptedLetter(table, message[index], key[index]));

            return encryptedMessage.ToString();
        }

        private static string GetKey(int messageLength)
        {
            char[] newKey = new char[messageLength];

            int keyIndex = 0;

            for (int index = 0; index < messageLength; index++)
            {
                if (index % KEY.Length == 0)
                    keyIndex = 0;

                newKey[index] = KEY[keyIndex];

                keyIndex++;
            }

            return new string(newKey);
        }

        public static char[,] CreateTable()
        {
            char[,] table = new char[26, 26];

            byte startLetter = START_LETTER;

            for (int row = 0; row < ALPHABET_LENGTH; row++)
            {
                char[] line = CreateTableLine(startLetter);

                for (int column = 0; column < ALPHABET_LENGTH; column++)
                    table[row, column] = line[column];

                startLetter++;
            }

            return table;
        }

        public static char[] CreateTableLine(byte startAt)
        {
            char[] tableLine = new char[26];
            int finishAt = startAt + ALPHABET_LENGTH;


            for (int index = startAt; index < finishAt; index++)
            {
                int letter = index;

                if (letter > FINISH_LETTER)
                {
                    int dif = letter - FINISH_LETTER;
                    letter = START_LETTER + dif - 1;
                }

                tableLine[index - startAt] = (char)letter;
            }

            return tableLine;
        }

        public static char FindDecryptedLetter(char[,] table, char encryptedLetter, char keyLetter)
        {
            char[] keyLine = GetRow(table, LINE_KEY_INDEX);

            int indexKeyLetter = Array.IndexOf(keyLine, keyLetter);

            char[] column = GetColumn(table, indexKeyLetter);

            int decryptedLetterIndex = Array.IndexOf(column, encryptedLetter);

            return keyLine[decryptedLetterIndex];
        }

        public static char FindEncryptedLetter(char[,] table, char messageLetter, char keyLetter)
        {
            char[] keyLine = GetRow(table, LINE_KEY_INDEX);

            int indexKeyLetter = Array.IndexOf(keyLine, keyLetter);
            int indexMessageLetter = Array.IndexOf(keyLine, messageLetter);

            return table[indexKeyLetter, indexMessageLetter];
        }

        public static char[] GetColumn(char[,] table, int columnNumber)
        {
            return Enumerable.Range(0, table.GetLength(0))
                    .Select(x => table[x, columnNumber])
                    .ToArray();
        }

        public static char[] GetRow(char[,] table, int rowNumber)
        {
            return Enumerable.Range(0, table.GetLength(1))
                    .Select(x => table[rowNumber, x])
                    .ToArray();
        }
    }
}
