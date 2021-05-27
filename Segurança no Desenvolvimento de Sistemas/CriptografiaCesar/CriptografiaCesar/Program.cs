using System;
using System.Text;

namespace CriptografiaCesar
{
    class Program
    {
        const sbyte CESAR_RULE = 7;
        static void Main(string[] args)
        {
            string encryptedMessage = Encrypt("Esta mensagem vai ser criptografada");
            string decryptedMessage = Decrypt(encryptedMessage);
            Console.WriteLine($"Encrypted message: {encryptedMessage}\nDecrypted message: {decryptedMessage}");
        }

        private static string Encrypt(string message, sbyte cesarRule = CESAR_RULE)
        {
            StringBuilder stringBuilder = new StringBuilder();

            foreach (char letter in message)
                stringBuilder.Append(GetCharEncrypted(letter, cesarRule));

            return stringBuilder.ToString();
        }

        private static string Decrypt(string message)
        {
            return Encrypt(message, -CESAR_RULE);
        }

        private static char GetCharEncrypted(char letter, sbyte cesarRule)
        {
            if (char.IsWhiteSpace(letter)) return letter;

            bool isLower = char.IsLower(letter);
            byte startASCII = isLower ? (byte)'a' : (byte)'A';
            byte endASCII = isLower ? (byte)'z' : (byte)'Z';

            int resultLetter = (byte)letter + cesarRule;

            if (resultLetter > endASCII)
                resultLetter = startASCII + (resultLetter - endASCII) - 1;

            if (resultLetter < startASCII)
                resultLetter = endASCII + (resultLetter - startASCII) + 1;

            return (char)resultLetter;
        }

    }
}
