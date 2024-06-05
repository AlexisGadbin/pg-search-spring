import { themes } from './constants'

export type Theme = (typeof themes)[number]

export type SearchTypes = 'trigram' | 'phonetic' | 'distance'

export type Artist = {
  artistId: number
  name: string
  nationality: string
  gender: string
  birthYear: number | null
  deathYear: number | null
}
