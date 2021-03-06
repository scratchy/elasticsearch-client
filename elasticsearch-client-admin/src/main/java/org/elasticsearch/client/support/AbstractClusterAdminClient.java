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
package org.elasticsearch.client.support;

import org.elasticsearch.action.*;
import org.elasticsearch.action.admin.cluster.ClusterAction;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthAction;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequestBuilder;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.action.admin.cluster.node.hotthreads.NodesHotThreadsAction;
import org.elasticsearch.action.admin.cluster.node.hotthreads.NodesHotThreadsRequest;
import org.elasticsearch.action.admin.cluster.node.hotthreads.NodesHotThreadsRequestBuilder;
import org.elasticsearch.action.admin.cluster.node.hotthreads.NodesHotThreadsResponse;
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoAction;
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoRequest;
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoRequestBuilder;
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoResponse;
import org.elasticsearch.action.admin.cluster.node.restart.NodesRestartAction;
import org.elasticsearch.action.admin.cluster.node.restart.NodesRestartRequest;
import org.elasticsearch.action.admin.cluster.node.restart.NodesRestartRequestBuilder;
import org.elasticsearch.action.admin.cluster.node.restart.NodesRestartResponse;
import org.elasticsearch.action.admin.cluster.node.shutdown.NodesShutdownAction;
import org.elasticsearch.action.admin.cluster.node.shutdown.NodesShutdownRequest;
import org.elasticsearch.action.admin.cluster.node.shutdown.NodesShutdownRequestBuilder;
import org.elasticsearch.action.admin.cluster.node.shutdown.NodesShutdownResponse;
import org.elasticsearch.action.admin.cluster.node.stats.NodesStatsAction;
import org.elasticsearch.action.admin.cluster.node.stats.NodesStatsRequest;
import org.elasticsearch.action.admin.cluster.node.stats.NodesStatsRequestBuilder;
import org.elasticsearch.action.admin.cluster.node.stats.NodesStatsResponse;
import org.elasticsearch.action.admin.cluster.reroute.ClusterRerouteAction;
import org.elasticsearch.action.admin.cluster.reroute.ClusterRerouteRequest;
import org.elasticsearch.action.admin.cluster.reroute.ClusterRerouteRequestBuilder;
import org.elasticsearch.action.admin.cluster.reroute.ClusterRerouteResponse;
import org.elasticsearch.action.admin.cluster.settings.ClusterUpdateSettingsAction;
import org.elasticsearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
import org.elasticsearch.action.admin.cluster.settings.ClusterUpdateSettingsRequestBuilder;
import org.elasticsearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
import org.elasticsearch.action.admin.cluster.state.ClusterStateAction;
import org.elasticsearch.action.admin.cluster.state.ClusterStateRequest;
import org.elasticsearch.action.admin.cluster.state.ClusterStateRequestBuilder;
import org.elasticsearch.action.admin.cluster.state.ClusterStateResponse;
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequestBuilder;
import org.elasticsearch.action.admin.indices.alias.IndicesGetAliasesAction;
import org.elasticsearch.action.admin.indices.alias.IndicesGetAliasesRequest;
import org.elasticsearch.action.admin.indices.alias.IndicesGetAliasesRequestBuilder;
import org.elasticsearch.action.admin.indices.alias.IndicesGetAliasesResponse;
import org.elasticsearch.client.ClusterAdminClient;

/**
 *
 */
public abstract class AbstractClusterAdminClient implements ClusterAdminClient {

    public <Request extends ActionRequest, Response extends ActionResponse, RequestBuilder extends ActionRequestBuilder<Request, Response, RequestBuilder>> RequestBuilder prepareExecute(ClusterAction<Request, Response, RequestBuilder> action) {
        return action.newRequestBuilder(this);
    }

    public ActionFuture<ClusterHealthResponse> health(final ClusterHealthRequest request) {
        return execute(ClusterHealthAction.INSTANCE, request);
    }

    public void health(final ClusterHealthRequest request, final ActionListener<ClusterHealthResponse> listener) {
        execute(ClusterHealthAction.INSTANCE, request, listener);
    }

    public ClusterHealthRequestBuilder prepareHealth(String... indices) {
        return new ClusterHealthRequestBuilder(this).setIndices(indices);
    }

    public ActionFuture<ClusterStateResponse> state(final ClusterStateRequest request) {
        return execute(ClusterStateAction.INSTANCE, request);
    }

    public void state(final ClusterStateRequest request, final ActionListener<ClusterStateResponse> listener) {
        execute(ClusterStateAction.INSTANCE, request, listener);
    }

    public ClusterStateRequestBuilder prepareState() {
        return new ClusterStateRequestBuilder(this);
    }

    public ActionFuture<ClusterRerouteResponse> reroute(final ClusterRerouteRequest request) {
        return execute(ClusterRerouteAction.INSTANCE, request);
    }

    public void reroute(final ClusterRerouteRequest request, final ActionListener<ClusterRerouteResponse> listener) {
        execute(ClusterRerouteAction.INSTANCE, request, listener);
    }

    public ClusterRerouteRequestBuilder prepareReroute() {
        return new ClusterRerouteRequestBuilder(this);
    }

    public ActionFuture<ClusterUpdateSettingsResponse> updateSettings(final ClusterUpdateSettingsRequest request) {
        return execute(ClusterUpdateSettingsAction.INSTANCE, request);
    }

    public void updateSettings(final ClusterUpdateSettingsRequest request, final ActionListener<ClusterUpdateSettingsResponse> listener) {
        execute(ClusterUpdateSettingsAction.INSTANCE, request, listener);
    }

    public ClusterUpdateSettingsRequestBuilder prepareUpdateSettings() {
        return new ClusterUpdateSettingsRequestBuilder(this);
    }

    public ActionFuture<NodesInfoResponse> nodesInfo(final NodesInfoRequest request) {
        return execute(NodesInfoAction.INSTANCE, request);
    }

    public void nodesInfo(final NodesInfoRequest request, final ActionListener<NodesInfoResponse> listener) {
        execute(NodesInfoAction.INSTANCE, request, listener);
    }

    public NodesInfoRequestBuilder prepareNodesInfo(String... nodesIds) {
        return new NodesInfoRequestBuilder(this).setNodesIds(nodesIds);
    }

    public ActionFuture<NodesStatsResponse> nodesStats(final NodesStatsRequest request) {
        return execute(NodesStatsAction.INSTANCE, request);
    }

    public void nodesStats(final NodesStatsRequest request, final ActionListener<NodesStatsResponse> listener) {
        execute(NodesStatsAction.INSTANCE, request, listener);
    }

    public NodesStatsRequestBuilder prepareNodesStats(String... nodesIds) {
        return new NodesStatsRequestBuilder(this).setNodesIds(nodesIds);
    }

    public ActionFuture<NodesHotThreadsResponse> nodesHotThreads(NodesHotThreadsRequest request) {
        return execute(NodesHotThreadsAction.INSTANCE, request);
    }

    public void nodesHotThreads(NodesHotThreadsRequest request, ActionListener<NodesHotThreadsResponse> listener) {
        execute(NodesHotThreadsAction.INSTANCE, request, listener);
    }

    public NodesHotThreadsRequestBuilder prepareNodesHotThreads(String... nodesIds) {
        return new NodesHotThreadsRequestBuilder(this).setNodesIds(nodesIds);
    }

    public ActionFuture<NodesRestartResponse> nodesRestart(final NodesRestartRequest request) {
        return execute(NodesRestartAction.INSTANCE, request);
    }

    public void nodesRestart(final NodesRestartRequest request, final ActionListener<NodesRestartResponse> listener) {
        execute(NodesRestartAction.INSTANCE, request, listener);
    }

    public NodesRestartRequestBuilder prepareNodesRestart(String... nodesIds) {
        return new NodesRestartRequestBuilder(this).setNodesIds(nodesIds);
    }

    public ActionFuture<NodesShutdownResponse> nodesShutdown(final NodesShutdownRequest request) {
        return execute(NodesShutdownAction.INSTANCE, request);
    }

    public void nodesShutdown(final NodesShutdownRequest request, final ActionListener<NodesShutdownResponse> listener) {
        execute(NodesShutdownAction.INSTANCE, request, listener);
    }

    public NodesShutdownRequestBuilder prepareNodesShutdown(String... nodesIds) {
        return new NodesShutdownRequestBuilder(this).setNodesIds(nodesIds);
    }
}
