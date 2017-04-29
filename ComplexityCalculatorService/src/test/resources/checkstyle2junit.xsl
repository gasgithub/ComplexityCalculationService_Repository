<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:param name="workspace" select="system-property('WORKSPACE')"/>
    <xsl:param name="checkstyle" select="'checkstyle'"/>
  
    <xsl:output encoding="UTF-8" method="xml"></xsl:output>

    <xsl:template match="/">
        <testsuites>
            <xsl:for-each select="//checkstyle">
                <testsuite>
                    <xsl:attribute name="id">
                        <xsl:value-of select='$checkstyle' />
                    </xsl:attribute>
                    <xsl:attribute name="name">
                        <xsl:value-of select='$checkstyle' />
                    </xsl:attribute>
                    <xsl:apply-templates />
                </testsuite>
            </xsl:for-each>
        </testsuites>
    </xsl:template>

    <xsl:template match="file">
        <testcase>
            <xsl:attribute name="id">
                <xsl:value-of select="substring-after(@name,$workspace)" />
            </xsl:attribute>
            
            <xsl:attribute name="name">
              <xsl:value-of select="substring-after(@name,$workspace)" />
            </xsl:attribute>
            
            <xsl:call-template name="error" />
        </testcase>
    </xsl:template>

    <xsl:template name="error">
        <!-- junit xml format include first failure in a testcase -->
        <xsl:for-each select=".//error[position()&lt;=1]">
            <failure>
                <xsl:attribute name="message">
                    <xsl:value-of select=" @message" />
                </xsl:attribute>
                <xsl:attribute name="type">
                    <xsl:value-of select="@severity" />
                </xsl:attribute>
                <xsl:text>Line </xsl:text> <xsl:value-of select="@line" />
                <xsl:text>: </xsl:text> <xsl:value-of select="@message" />
            </failure>
        </xsl:for-each>
    </xsl:template>
   
</xsl:stylesheet>
