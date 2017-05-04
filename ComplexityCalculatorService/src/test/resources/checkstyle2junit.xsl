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
    <xsl:variable name="INPUT_DOCUMENT_FILENAME" select="(tokenize($document-uri,'/'))[last()]"/>
    
    <xsl:variable name="findbugs_package" select="'com.puppycrawl.tools.checkstyle.checks'" />
    
    <xsl:variable name="CHECKSTYLE_VALIDATION" select="'checkstyle'"/>
  
    <xsl:output encoding="UTF-8" method="xml"/>

    <xsl:template match="/">
        <testsuites>
            <xsl:for-each select="//checkstyle">
                <testsuite>
                    <xsl:attribute name="id">
                        <xsl:value-of select="$INPUT_DOCUMENT_FILENAME" />
                    </xsl:attribute>
                    <xsl:attribute name="name">
                        <xsl:value-of select="$CHECKSTYLE_VALIDATION" />
                    </xsl:attribute>
                    <xsl:apply-templates />
                </testsuite>
            </xsl:for-each>
        </testsuites>
    </xsl:template>

    <xsl:template match="file">
    
        <xsl:variable name="CLASSNAME" select="(tokenize(@name,$FILESEPARATOR))[last()]"/>

        <!-- 
                
                TODO: FULLY_QIALIFIED_CLASSNAME remove trailing .java & translate all / characters to . 
                
        -->
                        
        <xsl:variable name="FULLY_QUALIFIED_CLASSNAME" select="(substring-after(@name,$WORKSPACE))" />        
            
        <xsl:if test="not(./error)">
    
        <!-- if a file has no errors then process it as a test case that passed -->
        
            <testcase>
                <xsl:attribute name="id">
                    <xsl:value-of select="$CLASSNAME" />
                </xsl:attribute>
            
                <!-- this is the junit test case -->
                
                <xsl:attribute name="name">
                    <xsl:value-of select="$FULLY_QUALIFIED_CLASSNAME" />
                </xsl:attribute>    
            </testcase>

        </xsl:if>

        <xsl:if test="./error">
           
        <!-- if a file has errors then process each error as a test case that failed -->    

            <xsl:for-each select=".//error">          
        
                <testcase>            
                    <xsl:attribute name="id">
                    <xsl:value-of select="@source" />
                </xsl:attribute>

                <!-- this is the junit test case -->            
                <xsl:attribute name="name">
                    <xsl:value-of select="@source" />
                </xsl:attribute>

                    <!-- include all findbug violations as junit failures -->
        
                    <failure>
            
                        <!-- this is the junit details -->
                        <xsl:attribute name="message">
                            <xsl:value-of select="@message" />
                            <xsl:text> in </xsl:text>
                            <xsl:value-of select="$FULLY_QUALIFIED_CLASSNAME" />
                        </xsl:attribute>
                    
                        <xsl:attribute name="type">
                            <xsl:value-of select="@source" />
                        </xsl:attribute>

                        <!-- this is the junit exception -->
                        <xsl:text>At </xsl:text>
                        <xsl:value-of select="$CLASSNAME" />
                        <xsl:text>:[line </xsl:text>
                        <xsl:value-of select="@line" />
                        <xsl:text>]</xsl:text>                
                
                    </failure>
            
                </testcase>
  
            </xsl:for-each>
            
        </xsl:if>
            
    </xsl:template>
        
 

   
</xsl:stylesheet>
