<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- Command line arguments -->
    <xsl:param name="WORKSPACE" select="WORKSPACE"/>
    <xsl:param name="FILESEPARATOR" select="FILESEPARATOR"/>
    
    <!-- return the filename of the input document -->
    <xsl:variable name="base-uri" select="base-uri(.)"/>
    <xsl:variable name="document-uri" select="document-uri(.)"/>   
    <xsl:variable name="filename" select="(tokenize($document-uri,'/'))[last()]"/>
    
    <xsl:variable name="checkstyle" select="'checkstyle'"/>
  
    <xsl:output encoding="UTF-8" method="xml"/>

    <xsl:template match="/">
        <testsuites>
            <xsl:for-each select="//checkstyle">
                <testsuite>
                    <xsl:attribute name="id">
                        <xsl:value-of select="$filename" />
                    </xsl:attribute>
                    <xsl:attribute name="name">
                        <xsl:value-of select="$checkstyle" />
                    </xsl:attribute>
                    <xsl:apply-templates />
                </testsuite>
            </xsl:for-each>
        </testsuites>
    </xsl:template>

    <xsl:template match="file">
        <testcase>
            <xsl:attribute name="id">
                <xsl:value-of select="substring-after(@name,$WORKSPACE)" />
            </xsl:attribute>
            
            <xsl:attribute name="name">
                <xsl:value-of select="substring-after(@name,$WORKSPACE)" />
            </xsl:attribute>
            
            <xsl:call-template name="error" />
        </testcase>
    </xsl:template>

    <xsl:template name="error">
        <!-- Windows: enter four backlashes for this variable, FILESEPARATOR="\\\\" -->
        <!-- Linux: enter single forward for this variable, FILESEPARATOR="/" -->
        <xsl:variable name="source_filename" select="(tokenize(@name,$FILESEPARATOR))[last()]"/>
        <!-- junit xml format include first failure in a testcase -->
        <xsl:for-each select=".//error[position()&lt;=1]">
        
            <!-- return the filename of the source -->
        
            <failure>
                <xsl:attribute name="message">
                    <xsl:value-of select=" @message" />
                </xsl:attribute>
                <xsl:attribute name="type">
                    <xsl:value-of select="@severity" />
                </xsl:attribute>
                <xsl:value-of select="$source_filename" />
                <xsl:text>(</xsl:text> <xsl:value-of select="@line" /> <xsl:text>)</xsl:text>
                <xsl:text>: </xsl:text> <xsl:value-of select="@message" />
            </failure>
        </xsl:for-each>
    </xsl:template>
   
</xsl:stylesheet>
