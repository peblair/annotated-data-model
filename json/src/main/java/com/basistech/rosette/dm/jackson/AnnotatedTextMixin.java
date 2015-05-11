/******************************************************************************
 ** This data and information is proprietary to, and a valuable trade secret
 ** of, Basis Technology Corp.  It is given in confidence by Basis Technology
 ** and may only be used as permitted under the license agreement under which
 ** it has been distributed, and in no other way.
 **
 ** Copyright (c) 2014 Basis Technology Corporation All rights reserved.
 **
 ** The technical data and information provided herein are provided with
 ** `limited rights', and the computer software provided herein is provided
 ** with `restricted rights' as those terms are defined in DAR and ASPR
 ** 7-104.9(a).
 ******************************************************************************/

package com.basistech.rosette.dm.jackson;

import com.basistech.rosette.dm.BaseAttribute;
import com.basistech.rosette.dm.BaseNounPhrase;
import com.basistech.rosette.dm.CategorizerResult;
import com.basistech.rosette.dm.EntityMention;
import com.basistech.rosette.dm.LanguageDetection;
import com.basistech.rosette.dm.ListAttribute;
import com.basistech.rosette.dm.ResolvedEntity;
import com.basistech.rosette.dm.ScriptRegion;
import com.basistech.rosette.dm.Sentence;
import com.basistech.rosette.dm.Token;
import com.basistech.rosette.dm.TranslatedData;
import com.basistech.rosette.dm.TranslatedTokens;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

import java.util.List;
import java.util.Map;

/**
 * {@link com.basistech.rosette.dm.AnnotatedText}.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public abstract class AnnotatedTextMixin {

    @JsonCreator
    AnnotatedTextMixin(@JsonProperty("data") CharSequence data,
                  @JsonProperty("attributes") Map<String, BaseAttribute> attributes,
                  @JsonProperty("documentMetadata") Map<String, List<String>> documentMetadata) {
        //
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM, include = JsonTypeInfo.As.PROPERTY, property = "type")
    @JsonTypeIdResolver(DmTypeIdResolver.class)
    public abstract Map<String, BaseAttribute> getAttributes();

    @JsonIgnore
    public abstract ListAttribute<Token> getTokens();

    @JsonIgnore
    public abstract ListAttribute<TranslatedData> getTranslatedData();

    @JsonIgnore
    public abstract ListAttribute<TranslatedTokens> getTranslatedTokens();

    @JsonIgnore
    public abstract ListAttribute<EntityMention> getEntityMentions();

    @JsonIgnore
    public abstract ListAttribute<ResolvedEntity> getResolvedEntities();

    @JsonIgnore
    public abstract ListAttribute<ScriptRegion> getScriptRegions();

    @JsonIgnore
    public abstract ListAttribute<Sentence> getSentences();

    @JsonIgnore
    public abstract ListAttribute<BaseNounPhrase> getBaseNounPhrases();

    @JsonIgnore
    public abstract ListAttribute<LanguageDetection> getLanguageDetectionRegions();

    @JsonIgnore
    public abstract LanguageDetection getWholeTextLanguageDetection();

    @JsonIgnore
    public abstract ListAttribute<CategorizerResult> getCategorizerResults();

    @JsonIgnore
    public abstract ListAttribute<CategorizerResult> getSentimentResults();
}