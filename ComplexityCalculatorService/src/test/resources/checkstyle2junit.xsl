<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- Command line arguments -->
    <xsl:param name="WORKSPACE" select="WORKSPACE"/>
    
    <!-- Windows => enter four backlashes for this variable, FILESEPARATOR="\\\\"
         Linux   => enter single forward for this variable, FILESEPARATOR="/"
    -->  
    <xsl:param name="FILESEPARATOR" select="FILESEPARATOR"/>
    
    <!-- return the filename of the input document -->
    <xsl:variable name="base-uri" select="base-uri(.)"/>
    <xsl:variable name="document-uri" select="document-uri(.)"/>   
    <xsl:variable name="filename" select="(tokenize($document-uri,'/'))[last()]"/>
    
    <xsl:variable name="findbugs_package" select="'com.puppycrawl.tools.checkstyle.checks'" />
    
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
        <!-- process each error as though it were a separate test case -->
        <xsl:for-each select=".//error">  
            <xsl:call-template name="error" />
        </xsl:for-each>
    </xsl:template>

    <xsl:template name="error">

        <!-- return the filename of the component under test (CUT) -->
        <xsl:variable name="CUT" select="(tokenize(@name,$FILESEPARATOR))[last()]"/>

        <testcase>
            <xsl:attribute name="id">
                <xsl:value-of select="@source" />
            </xsl:attribute>
            
            <xsl:attribute name="name">
                <xsl:value-of select="@source" />
            </xsl:attribute>
            
        </testcase>

        <!-- junit xml format include first failure in a testcase -->
<!--        <xsl:for-each select=".//error[position()&lt;=1]">     -->
        
            <failure>
            
                <xsl:attribute name="message">
                <!--
                    <xsl:value-of select="$CUT" />
                    <xsl:text>(</xsl:text> <xsl:value-of select="@line" /> <xsl:text>)</xsl:text>
                    <xsl:text>: </xsl:text> <xsl:value-of select="@message" />
                -->
                    <xsl:value-of select="@message" />
                </xsl:attribute>
                <xsl:attribute name="type">
                    <xsl:value-of select="@source" />
                </xsl:attribute>
                <!-- There's no stack trace in the input file so replicate the message 
                <xsl:value-of select="$CUT" />
                <xsl:text>(</xsl:text> <xsl:value-of select="@line" /> <xsl:text>)</xsl:text>
                <xsl:text>: </xsl:text> <xsl:value-of select="@message" />
                -->
                <xsl:text>At </xsl:text>
                <xsl:value-of select="$CUT" />
                <xsl:text>:[line </xsl:text>
                <xsl:value-of select="@line" />
                <xsl:text>]</xsl:text>
            </failure>

    </xsl:template>
   
</xsl:stylesheet>
