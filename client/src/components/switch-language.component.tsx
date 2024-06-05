'use client'

import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from '@components/ui/select'
import { Locales } from '@src/middleware'
import { useLocale } from 'next-intl'
import { useRouter } from 'next/navigation'
import { useTransition } from 'react'

type SwitchLanguageProps = {
  options: {
    value: Locales
    label: string
  }[]
}

const SwitchLanguage = (props: SwitchLanguageProps) => {
  const [isPending, startTransition] = useTransition()
  const router = useRouter()
  const activeLocale = useLocale()
  const { options } = props

  const handleChange = (locale: string) => {
    startTransition(() => {
      router.replace(`/${locale}`)
    })
  }

  return (
    <Select
      defaultValue={activeLocale}
      onValueChange={handleChange}
      disabled={isPending}
    >
      <SelectTrigger className="w-[180px]">
        <SelectValue />
      </SelectTrigger>
      <SelectContent>
        {options.map((option) => (
          <SelectItem key={option.value} value={option.value}>
            {option.label}
          </SelectItem>
        ))}
      </SelectContent>
    </Select>
  )
}
export default SwitchLanguage
