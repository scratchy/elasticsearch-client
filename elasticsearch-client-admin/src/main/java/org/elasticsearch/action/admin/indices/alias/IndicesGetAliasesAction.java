/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.action.admin.indices.alias;

import org.elasticsearch.action.admin.indices.IndicesAction;
import org.elasticsearch.client.IndicesAdminClient;

/**
 */
public class IndicesGetAliasesAction extends IndicesAction<IndicesGetAliasesRequest, IndicesGetAliasesResponse, IndicesGetAliasesRequestBuilder> {

    public static final IndicesGetAliasesAction INSTANCE = new IndicesGetAliasesAction();
    public static final String NAME = "indices/aliases/get";

    private IndicesGetAliasesAction() {
        super(NAME);
    }

    @Override
    public IndicesGetAliasesResponse newResponse() {
        return new IndicesGetAliasesResponse();
    }

    @Override
    public IndicesGetAliasesRequestBuilder newRequestBuilder(IndicesAdminClient client) {
        return new IndicesGetAliasesRequestBuilder(client);
    }
}
