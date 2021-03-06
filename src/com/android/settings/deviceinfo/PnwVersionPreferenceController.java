/*
 * Copyright (C) 2017 Paranoid Android
 * Copyright (C) 2017 Project New World
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.settings.deviceinfo;

import android.content.Context;
import android.os.SystemProperties;
import android.support.v7.preference.Preference;
import android.text.TextUtils;

import com.android.settings.core.PreferenceControllerMixin;
import com.android.settingslib.core.AbstractPreferenceController;

public class PnwVersionPreferenceController extends AbstractPreferenceController
        implements PreferenceControllerMixin {

    private static final String KEY_PNW_VERSION = "pnw_version";
    private static final String KEY_PNW_VERSION_PROPERTY = "ro.pnw.version";

    public PnwVersionPreferenceController(Context context) {
        super(context);
    }

    @Override
    public boolean isAvailable() {
        return !TextUtils.isEmpty(SystemProperties.get(KEY_PNW_VERSION_PROPERTY));
    }

    @Override
    public void updateState(Preference preference) {
        super.updateState(preference);
        preference.setSummary(SystemProperties.get(KEY_PNW_VERSION_PROPERTY));
    }

    @Override
    public String getPreferenceKey() {
        return KEY_PNW_VERSION;
    }
}
