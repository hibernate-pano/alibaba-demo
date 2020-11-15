/*
 * Copyright 2002-2014 the original author or authors.
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

package kit.pano.alibaba.com.demo.jacksonDemo.view;

public class View {

	//定义了一种视图，定义成interface就好了，不需要实现
	public interface Summary {}

	//定义了SummaryWithRecipients的视图，注意这个视图extends了Summary。所以这个视图包含了Summary视图。也就是，输出这个视图时候，同时输出Summary视图。
	public interface SummaryWithRecipients extends Summary {}

}
