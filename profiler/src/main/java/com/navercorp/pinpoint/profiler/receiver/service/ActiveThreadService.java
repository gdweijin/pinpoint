/*
 *
 *  * Copyright 2014 NAVER Corp.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 *
 */

package com.navercorp.pinpoint.profiler.receiver.service;

import com.navercorp.pinpoint.profiler.context.active.ActiveTraceLocator;
import com.navercorp.pinpoint.profiler.receiver.ProfilerCommandService;
import com.navercorp.pinpoint.profiler.receiver.ProfilerCommandServiceGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Taejin Koo
 */
public class ActiveThreadService implements ProfilerCommandServiceGroup {

    private final List<ProfilerCommandService> serviceList;

    public ActiveThreadService(ActiveTraceLocator activeTraceLocator) {
        serviceList = new ArrayList<ProfilerCommandService>();
        serviceList.add(new ActiveThreadCountService(activeTraceLocator));
        serviceList.add(new ActiveThreadDumpService(activeTraceLocator));

        // will be added ActiveThreadTraceService
    }

    @Override
    public List<ProfilerCommandService> getCommandServiceList() {
        return serviceList;
    }

}
