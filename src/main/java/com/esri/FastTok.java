package com.esri;

/**
 */
public final class FastTok
{
    public String[] tokens;

    public FastTok()
    {
        this(256);
    }

    public FastTok(final int numTokens)
    {
        tokens = new String[numTokens];
    }

    public int tokenize(
            final String text,
            final char delimiter)
    {
        final int newLen = text.length() / 2 + 2;
        if (tokens.length < newLen)
        {
            tokens = new String[newLen];
        }
        return _tokenize(text, delimiter);
    }

    public int tokenize2(
            final String text,
            final char delimiter)
    {
        return _tokenize(text, delimiter);
    }

    public String[] tokenize3(
            final String text,
            final char delimiter)
    {
        _tokenize(text, delimiter);
        return tokens;
    }

    int _tokenize(final String text, final char delimiter)
    {
        int count = 0;

        int i = 0;
        int j = text.indexOf(delimiter);

        while (j >= 0)
        {
            tokens[count++] = text.substring(i, j);
            i = j + 1;
            j = text.indexOf(delimiter, i);
        }
        tokens[count++] = text.substring(i);

        return count;
    }

    public final static String[] toTokens(
            final String line,
            final char delimiter)
    {
        final FastTok fastTok = new FastTok(line.length() / 2 + 2);
        fastTok._tokenize(line, delimiter);
        return fastTok.tokens;
    }

    public final static String[] toTokens2(
            final String line,
            final char delimiter)
    {
        final FastTok fastTok = new FastTok(line.length() + 1);
        fastTok._tokenize(line, delimiter);
        return fastTok.tokens;
    }
}