/*
 *    Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License").
 *    You may not use this file except in compliance with the License.
 *    A copy of the License is located at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    or in the "license" file accompanying this file. This file is distributed
 *    on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 *    express or implied. See the License for the specific language governing
 *    permissions and limitations under the License.
 *
 */

package com.amazon.opendistroforelasticsearch.sql.planner.logical;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class LogicalJoin extends LogicalPlan {

    private final LogicalPlan left;
    private final LogicalPlan right;
    private final String joinType;
    private final List<String> joinFieldNames;

    @Override
    public <R, C> R accept(AbstractPlanNodeVisitor<R, C> visitor, C context) {
        return visitor.visitJoin(this, context);
    }

    @Override
    public List<LogicalPlan> getChild() {
        return Arrays.asList(left, right);
    }
}