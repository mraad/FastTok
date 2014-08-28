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

    public FastTok(final int length)
    {
        tokens = new String[length];
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
        fastTok.tokenize(line, delimiter);
        return fastTok.tokens;
    }
}