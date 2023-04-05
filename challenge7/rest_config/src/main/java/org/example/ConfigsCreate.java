/*
 *
 *  * Talkdesk Confidential
 *  *
 *  * Copyright (C) Talkdesk Inc. 2022
 *  *
 *  * The source code for this program is not published or otherwise divested
 *  * of its trade secrets, irrespective of what has been deposited with the
 *  * U.S. Copyright Office. Unauthorized copying of this file, via any medium
 *  * is strictly prohibited.
 *
 */

package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
public class ConfigsCreate {

    private Boolean active;

}
