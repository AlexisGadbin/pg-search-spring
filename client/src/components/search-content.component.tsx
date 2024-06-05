'use client'

import { Artist, SearchTypes } from '@src/utils/types'
import { useQuery } from '@tanstack/react-query'
import { useState } from 'react'
import { Input } from './ui/input'
import { Label } from './ui/label'

type SearchContentProps = {
  type: SearchTypes
  placeholder: string
  label: string
}

const SearchContent = (props: SearchContentProps) => {
  const { type, placeholder, label } = props
  const [search, setSearch] = useState('')

  const { data: artists, refetch } = useQuery<Artist[]>({
    queryKey: ['artists'],
    queryFn: async () => {
      const response = await fetch(
        `http://localhost:8080/artists/${type}?q=${search}`
      )
      return response.json()
    },
    staleTime: 1000,
  })

  return (
    <div>
      <div className="grid w-full max-w-sm items-center gap-1.5">
        <Label htmlFor={label}>
          {label.charAt(0).toUpperCase() + label.slice(1)}
        </Label>
        <Input
          id={label}
          type="search"
          placeholder={'Search...'}
          className="w-full"
          value={search}
          onChange={(e) => {
            setSearch(e.target.value)
            refetch()
          }}
        />

        {artists?.map((artist) => (
          <div key={artist.artistId}>{artist.name}</div>
        ))}
      </div>
    </div>
  )
}
export default SearchContent
