/*
 * This file is part of Apparat.
 *
 * Apparat is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Apparat is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Apparat. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2009 Joa Ebert
 * http://www.joa-ebert.com/
 *
 * Author : Patrick Le Clec'h
 */

package apparat.asm {
	/**
	 * The __as3 function allows emits bytecode generated by the ActionScript compiler
	 * into ASM blocks.
	 *
	 * The result of the <code>__as3</code> function is treated special if an ASM statement
	 * expects an ABC name or namespace. <code>FindPropStrict</code> is such a statement for
	 * example. TurboDieselSportInjection will try to guess the required name or namespace
	 * by analyzing the result of the <code>__as3</code> bytecode.
	 *
	 *
	 * @author Patrick Le Clec'h
	 * @see __asm
	 * 
	 * @example
	 * <pre>
	 * __asm(
	 *    // This is equal to FindPropStrict(AbcQName("trace", AbcNamespace(NamespaceKind.PACKAGE, "")))
	 *    // as noted above.
	 *	  FindPropStrict(__as3(trace)),
	 *	  PushString('Hello World!'),
	 *	  CallPropVoid(__as3(trace), 1)
	 * );
	 * </pre>
	 *
	 * @example
	 * <pre>
	 * var x: int = 12;
	 * __asm(
	 *    // This will push the result of the comparison x<10 to the stack.
	 *    // In this example the result would be false.
	 * 	   __as3(x<10)
	 * );
	 * </pre>
	 */
	public function __as3(value: *): void {}
}