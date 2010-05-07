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
 */

package com.joa_ebert.apparat.swf;

/**
 * 
 * @author Joa Ebert
 * 
 */
public class SwfException extends Exception
{
	private static final long serialVersionUID = -5828728670213381580L;

	public SwfException()
	{
		super();
	}

	public SwfException( final String message )
	{
		super( message );
	}

	public SwfException( final String message, final Throwable throwable )
	{
		super( message, throwable );
	}

	public SwfException( final Throwable throwable )
	{
		super( throwable );
	}
}
